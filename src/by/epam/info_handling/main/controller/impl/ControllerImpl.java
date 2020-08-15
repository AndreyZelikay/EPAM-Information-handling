package by.epam.info_handling.main.controller.impl;

import by.epam.info_handling.main.controller.Controller;

import java.io.OutputStream;
import java.io.PrintWriter;

public abstract class ControllerImpl implements Controller {
    protected void handleBadRequest(OutputStream out) {
        PrintWriter writer = new PrintWriter(out);

        writer.println("bad request");
    }
}
