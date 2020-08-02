package by.epam.info_handling.dao.impl;

import by.epam.info_handling.dao.TextDao;
import by.epam.info_handling.dao.exception.DaoException;
import by.epam.info_handling.dao.reader.ProgrammingTextReader;
import by.epam.info_handling.model.Text;
import by.epam.info_handling.model.TextElement;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class TextDaoImpl implements TextDao {

    private ProgrammingTextReader reader;
    private Text text;

    {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("src\\resources\\config.properties")));

            reader = new ProgrammingTextReader(
                    new BufferedReader(new FileReader(properties.getProperty("filename"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Text getText() {
        if(text != null) {
            return text;
        }

        TextElement textElement;
        List<TextElement> elements = new LinkedList<>();

        try {
            while ((textElement = reader.readNextTextElement()) != null) {
                elements.add(textElement);
            }
        } catch (IOException e) {
            throw new DaoException("can not read text " + e.getMessage());
        }

        Text text = new Text();
        text.setElements(elements);

        this.text = text;

        return text;
    }
}
