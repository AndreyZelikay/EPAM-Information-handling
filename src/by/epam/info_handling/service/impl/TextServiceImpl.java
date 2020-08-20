package by.epam.info_handling.service.impl;

import by.epam.info_handling.dao.DaoFactory;
import by.epam.info_handling.dao.TextDao;
import by.epam.info_handling.domain.entity.Sentence;
import by.epam.info_handling.domain.entity.Text;
import by.epam.info_handling.service.SentenceService;
import by.epam.info_handling.service.ServiceFactory;
import by.epam.info_handling.service.TextService;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class TextServiceImpl implements TextService {

    private final TextDao textDao;

    public TextServiceImpl() {
        this.textDao = DaoFactory.getInstance().getTextDao();
    }

    @Override
    public Text getText() {
        return textDao.getText();
    }

    @Override
    public List<Sentence> getSentencesWithRepeatedWords() {
        Text text = textDao.getText();
        SentenceService sentenceService = ServiceFactory.getInstance().getSentenceService();

        List<Sentence> result = new LinkedList<>();

        for (Sentence sentence : text.getSentences()) {
            List<String> words = sentenceService.getWords(sentence);
            long countOfRepeatedWords = words.size() -
                    words.stream().distinct().count();

            if (countOfRepeatedWords > 0) {
                result.add(sentence);
            }
        }

        return result;
    }

    @Override
    public List<Sentence> getSentencesInAscendingOrderOfWords() {
        Text text = textDao.getText();
        SentenceService sentenceService = ServiceFactory.getInstance().getSentenceService();

        List<Sentence> sentences = text.getSentences();

        sentences.sort(Comparator.comparingInt(s -> sentenceService.getWords(s).size()));

        return sentences;
    }

    @Override
    public String findUniqueWordInFirstSentence() {
        Text text = textDao.getText();
        SentenceService sentenceService = ServiceFactory.getInstance().getSentenceService();

        Sentence firstSentence = text.getSentences().get(0);

        for (String word : sentenceService.getWords(firstSentence)) {
            if (text.getSentences().stream().noneMatch(s -> sentenceService.getWords(s).contains(word))) {
                return word;
            }
        }

        return null;
    }
}
