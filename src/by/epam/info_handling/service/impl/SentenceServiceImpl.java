package by.epam.info_handling.service.impl;

import by.epam.info_handling.domain.entity.Sentence;
import by.epam.info_handling.domain.entity.SentencePart;
import by.epam.info_handling.domain.enumeration.SentencePartType;
import by.epam.info_handling.service.SentenceService;

import java.util.LinkedList;
import java.util.List;

public class SentenceServiceImpl implements SentenceService {
    @Override
    public List<String> getWords(Sentence sentence) {
        return getSpecificParts(sentence, SentencePartType.WORD);
    }

    @Override
    public List<String> getDelimiters(Sentence sentence) {
        return getSpecificParts(sentence, SentencePartType.DELIMITER);
    }

    private List<String> getSpecificParts(Sentence sentence, SentencePartType type) {
        List<String> result = new LinkedList<>();

        for (SentencePart part : sentence.getSentenceParts()) {
            if (part.getType().equals(type)) {
                result.add(part.getValue());
            }
        }

        return result;
    }
}
