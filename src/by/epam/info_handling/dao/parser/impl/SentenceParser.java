package by.epam.info_handling.dao.parser.impl;

import by.epam.info_handling.dao.parser.Parser;
import by.epam.info_handling.domain.entity.Sentence;
import by.epam.info_handling.domain.entity.SentencePart;
import by.epam.info_handling.domain.enumeration.SentencePartType;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements Parser {

    private static final String GET_WORDS_WITH_DELIMITERS_REGEX = "([\\w-%]+)|([ ,.;\n=])";

    private static final Pattern pattern = Pattern.compile(GET_WORDS_WITH_DELIMITERS_REGEX);

    public Sentence parse(String input) {
        Sentence sentence = new Sentence();

        sentence.setSentenceParts(getSentenceParts(input));

        return sentence;
    }

    private List<SentencePart> getSentenceParts(String input) {
        Matcher matcher = pattern.matcher(input);

        List<SentencePart> result = new LinkedList<>();

        while (matcher.find()) {
            SentencePart sentencePart = new SentencePart();

            if (matcher.group(1) != null) {
                sentencePart.setValue(matcher.group(1));
                sentencePart.setType(SentencePartType.WORD);
            } else {
                sentencePart.setValue(matcher.group(2));
                sentencePart.setType(SentencePartType.DELIMITER);
            }

            result.add(sentencePart);
        }

        return result;
    }
}
