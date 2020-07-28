package by.epam.info_handling.dao.parser.impl;

import by.epam.info_handling.model.CodeBlock;
import by.epam.info_handling.dao.parser.Parser;

public class CodeBlockParser implements Parser {

    public CodeBlock parse(String input) {
        CodeBlock codeBlock = new CodeBlock();

        codeBlock.setTextContent(input);

        return codeBlock;
    }
}
