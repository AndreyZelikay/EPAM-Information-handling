package by.epam.info_handling.main.controller;

import by.epam.info_handling.main.controller.impl.ControllerImpl;
import by.epam.info_handling.main.controller.impl.TextController;

import java.util.HashMap;
import java.util.Map;

public class ControllerDispatcher {
    private final Map<ControllerEnum, ControllerImpl> controllerStorage = new HashMap<>();
    private static final ControllerDispatcher instance = new ControllerDispatcher();

    private ControllerDispatcher() {
        controllerStorage.put(ControllerEnum.TEXT, new TextController());
    }

    public static ControllerDispatcher getInstance() {
        return instance;
    }

    public ControllerImpl getController(ControllerEnum controllerEnum) {
        return controllerStorage.get(controllerEnum);
    }
}
