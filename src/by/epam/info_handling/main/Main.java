package by.epam.info_handling.main;

import by.epam.info_handling.main.printer.TextPrinter;
import by.epam.info_handling.service.TextService;
import by.epam.info_handling.service.impl.TextServiceImpl;

public class Main {

    public static void main(String[] args) {
        TextService textService = new TextServiceImpl();

        TextPrinter.print(textService.getText());
    }
}
