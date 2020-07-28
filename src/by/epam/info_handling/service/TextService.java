package by.epam.info_handling.service;

import by.epam.info_handling.model.Sentence;
import by.epam.info_handling.model.Text;
import by.epam.info_handling.model.Word;

import java.util.List;

public interface TextService {
    Text getText();

    List<Sentence> getSentencesWithRepeatedWords();

    List<Sentence> getSentencesInAscendingOrderOfWords();

    Word findUniqueWordInFirstSentence();
}
