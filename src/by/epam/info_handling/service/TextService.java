package by.epam.info_handling.service;

import by.epam.info_handling.domain.entity.Sentence;
import by.epam.info_handling.domain.entity.Text;

import java.util.List;

public interface TextService {
    Text getText();

    List<Sentence> getSentencesWithRepeatedWords();

    List<Sentence> getSentencesInAscendingOrderOfWords();

    String findUniqueWordInFirstSentence();
}
