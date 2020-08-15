package by.epam.info_handling.main.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Controller {
    void service(InputStream in, OutputStream out) throws IOException;
}
