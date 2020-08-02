package by.epam.info_handling.main;

import by.epam.info_handling.main.printer.SentencePrinter;
import by.epam.info_handling.main.printer.TextPrinter;
import by.epam.info_handling.main.printer.WordPrinter;
import by.epam.info_handling.service.TextService;
import by.epam.info_handling.service.impl.TextServiceImpl;

public class Main {

    public static void main(String[] args) {
        TextService textService = new TextServiceImpl();

        WordPrinter.print(textService.findUniqueWordInFirstSentence());

        System.out.println("--------------------------------------");

        textService.getSentencesWithRepeatedWords().forEach(SentencePrinter::print);

        System.out.println("--------------------------------------");

        textService.getSentencesInAscendingOrderOfWords().forEach(SentencePrinter::print);

        System.out.println("--------------------------------------");

        TextPrinter.print(textService.getText());
    }
}
