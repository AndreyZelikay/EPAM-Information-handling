package by.epam.info_handling.service;

import by.epam.info_handling.service.impl.SentenceServiceImpl;
import by.epam.info_handling.service.impl.TextServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final SentenceService sentenceService = new SentenceServiceImpl();
    private final TextService textService = new TextServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public SentenceService getSentenceService() {
        return sentenceService;
    }

    public TextService getTextService() {
        return textService;
    }
}
