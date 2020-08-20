package by.epam.info_handling.web.controller;

import java.io.IOException;
import java.io.OutputStream;

public interface Controller {
    void service(String controllerMethodName, OutputStream out) throws IOException;
}
