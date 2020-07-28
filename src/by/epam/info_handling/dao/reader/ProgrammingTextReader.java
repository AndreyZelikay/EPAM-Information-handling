package by.epam.info_handling.dao.reader;

import by.epam.info_handling.model.TextElement;
import by.epam.info_handling.dao.parser.ParserManager;
import by.epam.info_handling.dao.parser.enumeration.ParserEnum;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgrammingTextReader {

    private static final String HEADING_REGEX = "^(\\d.)+?\\s+?.+?$";
    private static final String CODE_BLOCK_REGEX = "(void|class) [A-Za-z]? (\\(.*?\\))?\\{.*?\\}";
    private static final String SENTENCE_REGEX = "[A-Z]*?([.?:;])";

    private static final Pattern codeBlockPattern = Pattern.compile(CODE_BLOCK_REGEX);
    private static final Pattern headingPattern = Pattern.compile(HEADING_REGEX);
    private static final Pattern sentencePattern = Pattern.compile(SENTENCE_REGEX);

    private BufferedReader reader;
    private StringBuilder buffer;

    public ProgrammingTextReader(BufferedReader reader) {
        this.reader = reader;
        buffer = new StringBuilder();
    }

    public TextElement readNextTextElement() throws IOException {
        Matcher matcher;
        String line;

        while((line = reader.readLine()) != null) {
            buffer.append(line);

            matcher = codeBlockPattern.matcher(buffer.toString());

            if(matcher.find()) {
                String codeBlock = matcher.group();
                buffer = buffer.replace(matcher.start(), matcher.end(), "");
                return ParserManager.getParser(ParserEnum.CODE_BLOCK).parse(codeBlock);
            }

            matcher = headingPattern.matcher(buffer.toString());

            if(matcher.find()) {
                String heading = matcher.group();
                buffer = buffer.replace(matcher.start(), matcher.end(), "");
                return ParserManager.getParser(ParserEnum.HEADING).parse(heading);
            }

            matcher = sentencePattern.matcher(line);

            if(matcher.find()) {
                String sentence = matcher.group();
                buffer = buffer.replace(matcher.start(), matcher.end(), "");
                return ParserManager.getParser(ParserEnum.SENTENCE).parse(sentence);
            }
        }

        return null;
    }
}