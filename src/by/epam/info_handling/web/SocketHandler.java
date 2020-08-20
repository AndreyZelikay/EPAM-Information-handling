package by.epam.info_handling.web;

import by.epam.info_handling.web.controller.ControllerDispatcher;
import by.epam.info_handling.web.controller.ControllerEnum;

import java.io.*;
import java.net.Socket;

public class SocketHandler {

    public static final SocketHandler instance = new SocketHandler();

    private SocketHandler() {
    }

    public static SocketHandler getInstance() {
        return instance;
    }

    public void handleSocket(Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream());

        String request;

        while ((request = reader.readLine()) != null) {
            boolean noSuchController = true;

            for (ControllerEnum element : ControllerEnum.values()) {
                if (request.matches(String.format("(?i)%s:.*", element.toString()))) {
                    noSuchController = false;

                    ControllerDispatcher
                            .getInstance()
                            .getController(element)
                            .service(
                                    request.replaceAll(String.format("(?i)%s: ", element.toString()), ""),
                                    socket.getOutputStream());
                }
            }

            if (noSuchController) {
                writer.println("no such controller");
                writer.flush();
            }
        }
    }
}
