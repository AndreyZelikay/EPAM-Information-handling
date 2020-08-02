package by.epam.info_handling.dao.parser.impl;

import by.epam.info_handling.dao.parser.Parser;
import by.epam.info_handling.model.Delimiter;
import by.epam.info_handling.model.PartOfSentence;
import by.epam.info_handling.model.Sentence;
import by.epam.info_handling.model.Word;

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

    private List<PartOfSentence> getSentenceParts(String input) {
        Matcher matcher = pattern.matcher(input);

        List<PartOfSentence> result = new LinkedList<>();

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                result.add(new Word(matcher.group(1)));
            } else {
                result.add(new Delimiter(matcher.group(2)));
            }
        }

        return result;
    }
}
