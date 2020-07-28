package by.epam.info_handling.main.printer;

import by.epam.info_handling.model.Word;

public class WordPrinter {

    private WordPrinter() {
    }

    public static void print(Word data) {
        System.out.println(data.getContent());
    }
}
