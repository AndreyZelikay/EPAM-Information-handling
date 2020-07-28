package by.epam.info_handling.dao.parser.impl;

import by.epam.info_handling.model.Heading;
import by.epam.info_handling.model.TextElement;
import by.epam.info_handling.dao.parser.Parser;

public class HeadingParser implements Parser {
    @Override
    public TextElement parse(String input) {
        return new Heading(input);
    }
}
