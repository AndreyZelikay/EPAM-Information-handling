package by.epam.info_handling.service.impl;

import by.epam.info_handling.dao.DaoFactory;
import by.epam.info_handling.dao.TextDao;
import by.epam.info_handling.model.Sentence;
import by.epam.info_handling.model.Text;
import by.epam.info_handling.model.Word;
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
    public List<Sentence> getSentencesWithRepeatedWords(){
        Text text = textDao.getText();

        List<Sentence> result = new LinkedList<>();

        for(Sentence sentence: text.getSentences()) {
            long countOfRepeatedWords = sentence.getWords().size() -
                    sentence.getWords().stream().distinct().count();

            if(countOfRepeatedWords > 0) {
                result.add(sentence);
            }
        }

        return result;
    }

    @Override
    public List<Sentence> getSentencesInAscendingOrderOfWords() {
        Text text = textDao.getText();

        List<Sentence> sentences = text.getSentences();

        sentences.sort(Comparator.comparingInt(a -> a.getWords().size()));

        return sentences;
    }

    @Override
    public Word findUniqueWordInFirstSentence() {
        Text text = textDao.getText();

        Sentence firstSentence = text.getSentences().get(0);

        for(Word word: firstSentence.getWords()) {
            if(text.getSentences().stream().noneMatch(sentence -> sentence.getWords().contains(word))) {
                return word;
            }
        }

        return null;
    }
}
