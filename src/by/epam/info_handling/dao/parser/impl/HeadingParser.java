package by.epam.info_handling.dao.parser.impl;

import by.epam.info_handling.domain.entity.Heading;
import by.epam.info_handling.domain.entity.TextElement;
import by.epam.info_handling.dao.parser.Parser;

public class HeadingParser implements Parser {
    @Override
    public TextElement parse(String input) {
        return new Heading(input);
    }
}
