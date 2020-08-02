package by.epam.info_handling.dao;

import by.epam.info_handling.dao.impl.TextDaoImpl;

public class DaoFactory {

    private static final DaoFactory instance = new DaoFactory();

    private final TextDao textDao = new TextDaoImpl();

    private DaoFactory(){}

    public static DaoFactory getInstance() {
        return instance;
    }

    public TextDao getTextDao() {
        return textDao;
    }
}
