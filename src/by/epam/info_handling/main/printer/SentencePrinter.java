package by.epam.info_handling.main.printer;

import by.epam.info_handling.model.Sentence;

public class SentencePrinter {
    private SentencePrinter() {
    }

    public static void print(Sentence data) {
        System.out.println(data.getInitialValue());
    }
}
