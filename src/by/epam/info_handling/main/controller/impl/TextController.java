package by.epam.info_handling.main.controller.impl;

import by.epam.info_handling.model.Sentence;
import by.epam.info_handling.model.Word;
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
    public void service(InputStream in, OutputStream out) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String request = reader.readLine();

        switch (request) {
            case "sentence with repeated words":
                sentencesWithRepeatedWords(out);
                break;
            case "stop":
                return;
            case "sentences in ascending order of words":
                sentencesInAscendingOrderOfWords(out);
                break;
            case "unique word in first sentence" :
                uniqueWordInFirstSentence(out);
                break;
            default:
               super.handleBadRequest(out);
        }
    }

    private void sentencesInAscendingOrderOfWords(OutputStream out) throws IOException {
        List<Sentence> sentences = textService.getSentencesInAscendingOrderOfWords();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);

        objectOutputStream.writeObject(sentences);
        objectOutputStream.flush();
    }

    private void uniqueWordInFirstSentence(OutputStream out) throws IOException {
        Word word = textService.findUniqueWordInFirstSentence();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);

        objectOutputStream.writeObject(word);
        objectOutputStream.flush();
    }

    private void sentencesWithRepeatedWords(OutputStream out) throws IOException {
        List<Sentence> sentences = textService.getSentencesWithRepeatedWords();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);

        objectOutputStream.writeObject(sentences);
        objectOutputStream.flush();
    }
}
