package by.epam.info_handling.dao.parser;

import by.epam.info_handling.dao.parser.enumeration.ParserEnum;
import by.epam.info_handling.dao.parser.impl.CodeBlockParser;
import by.epam.info_handling.dao.parser.impl.HeadingParser;
import by.epam.info_handling.dao.parser.impl.SentenceParser;

import java.util.HashMap;
import java.util.Map;

public class ParserManager {

    private final static Map<ParserEnum, Parser> parsers = new HashMap<>();

    static {
        parsers.put(ParserEnum.SENTENCE, new SentenceParser());
        parsers.put(ParserEnum.CODE_BLOCK, new CodeBlockParser());
        parsers.put(ParserEnum.HEADING, new HeadingParser());
    }

    private ParserManager(){}

    public static Parser getParser(ParserEnum parserEnum) {
        return parsers.get(parserEnum);
    }
}
