package by.epam.info_handling.dao.reader;

import by.epam.info_handling.model.TextElement;
import by.epam.info_handling.dao.parser.ParserManager;
import by.epam.info_handling.dao.parser.enumeration.ParserEnum;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgrammingTextReader {

    private static final String HEADING_REGEX = "(\\d.)+?\\s+?[A-Z].*?(\n|$)";
    private static final String CODE_BLOCK_START_REGEX = "(class [A-Za-z]+ \\{)|(void [A-Za-z]+?\\(.*?\\) \\{)";
    private static final String CODE_BLOCK_REGEX = String.format("%s(.|\n)*?}\n*(?=[A-Z])", CODE_BLOCK_START_REGEX);
    private static final String SENTENCE_REGEX = "[A-Z][^{}]*?(([.?:;!]\n?)|\n(?=[A-Z]))";

    private static final Pattern codeBlockStartPattern = Pattern.compile(CODE_BLOCK_START_REGEX);
    private static final Pattern codeBlockPattern = Pattern.compile(CODE_BLOCK_REGEX);
    private static final Pattern headingPattern = Pattern.compile(HEADING_REGEX);
    private static final Pattern sentencePattern = Pattern.compile(SENTENCE_REGEX);

    private final BufferedReader reader;
    private StringBuilder buffer;

    public ProgrammingTextReader(BufferedReader reader) {
        this.reader = reader;
        buffer = new StringBuilder();
    }

    public TextElement readNextTextElement() throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line).append("\n");

            String textElement;

            if ((textElement = readHeading()) != null) {
                return ParserManager.getParser(ParserEnum.HEADING).parse(textElement);
            } else if ((textElement = readSentence()) != null) {
                return ParserManager.getParser(ParserEnum.SENTENCE).parse(textElement);
            } else if ((textElement = readCodeBlock()) != null) {
                return ParserManager.getParser(ParserEnum.CODE_BLOCK).parse(textElement);
            }
        }

        return null;
    }

    private String readCodeBlock() throws IOException {
        Matcher matcher = codeBlockStartPattern.matcher(buffer.toString());

        if (!matcher.find()) {
            return null;
        }

        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line).append("\n");
            matcher = codeBlockPattern.matcher(buffer.toString());

            if (matcher.find()) {
                buffer = buffer.replace(matcher.start(), matcher.end(), "");
                return matcher.group();
            }
        }

        return null;
    }

    private String readSentence() {
        Matcher matcher = sentencePattern.matcher(buffer.toString());

        if (matcher.find()) {
            buffer = buffer.replace(matcher.start(), matcher.end(), "");
            return matcher.group();
        }

        return null;
    }

    private String readHeading() {
        Matcher matcher = headingPattern.matcher(buffer.toString());

        if (matcher.find()) {
            buffer = buffer.replace(matcher.start(), matcher.end(), "");
            return matcher.group();
        }

        return null;
    }
}