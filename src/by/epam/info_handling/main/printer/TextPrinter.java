package by.epam.info_handling.main.printer;

import by.epam.info_handling.model.Text;

public class TextPrinter {
    private TextPrinter() {
    }

    public static void print(Text data) {
        System.out.println(data.getInitialValue());
    }
}
