package by.epam.info_handling.service;

import by.epam.info_handling.domain.entity.Sentence;

import java.util.List;

public interface SentenceService {
    List<String> getWords(Sentence sentence);

    List<String> getDelimiters(Sentence sentence);
}
