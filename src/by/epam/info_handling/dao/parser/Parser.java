package by.epam.info_handling.dao.parser;

import by.epam.info_handling.domain.entity.TextElement;

public interface Parser {
     TextElement parse(String input);
}
