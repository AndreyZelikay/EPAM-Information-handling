package by.epam.info_handling.dao.parser.impl;

import by.epam.info_handling.model.*;
import by.epam.info_handling.dao.parser.Parser;

import java.util.LinkedList;
import java.util.List;

public class SentenceParser implements Parser {

    private static final String GET_WORDS_WITH_DELIMITERS_REGEX = "[ ,.;]<=?";

    private static final String DELIMITERS_REGEX = "[ ,.;]";

    private static final String WORDS_REGEX = "[\\w\\W]";

    public Sentence parse(String input) {
        Sentence sentence = new Sentence();

        sentence.setSentenceParts(getSentenceParts(input));

        return sentence;
    }

    private List<PartOfSentence> getSentenceParts(String input) {
        String[] elements = input.split(GET_WORDS_WITH_DELIMITERS_REGEX);

        List<PartOfSentence> result = new LinkedList<>();

        for (String element: elements) {
            PartOfSentence word = new Word(element.replaceAll(DELIMITERS_REGEX, ""));
            PartOfSentence delimiter = new Delimiter(element.replaceAll(WORDS_REGEX, ""));

            result.add(word);
            result.add(delimiter);
        }

        return result;
    }
}
