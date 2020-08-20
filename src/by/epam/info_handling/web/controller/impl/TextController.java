package by.epam.info_handling.web.controller.impl;

import by.epam.info_handling.domain.entity.Sentence;
import by.epam.info_handling.service.TextService;
import by.epam.info_handling.service.impl.TextServiceImpl;

import java.io.*;
import java.util.List;

public class TextController extends ControllerImpl {

    private final TextService textService;

    public TextController() {
        textService = new TextServiceImpl();
    }

    @Override
    public void service(String controllerMethodName, OutputStream out) throws IOException {
        switch (controllerMethodName) {
            case "sentences with repeated words" -> sentencesWithRepeatedWords(out);
            case "sentences in ascending order of words" -> sentencesInAscendingOrderOfWords(out);
            case "unique word in first sentence" -> uniqueWordInFirstSentence(out);
            default -> super.handleBadRequest(out);
        }
    }

    private void sentencesInAscendingOrderOfWords(OutputStream out) throws IOException {
        List<Sentence> sentences = textService.getSentencesInAscendingOrderOfWords();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);

        objectOutputStream.writeObject(sentences);
        objectOutputStream.flush();
    }

    private void uniqueWordInFirstSentence(OutputStream out) throws IOException {
        String word = textService.findUniqueWordInFirstSentence();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);

        objectOutputStream.writeObject(word);
        objectOutputStream.flush();
    }

    private void sentencesWithRepeatedWords(OutputStream out) throws IOException {
        List<Sentence> sentences = textService.getSentencesWithRepeatedWords();

        ObjectOutput objectOutputStream = new ObjectOutputStream(out);

        try {
            objectOutputStream.writeObject(sentences);
            objectOutputStream.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
