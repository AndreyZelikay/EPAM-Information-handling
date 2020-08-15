package by.epam.info_handling.main;

import by.epam.info_handling.main.controller.ControllerDispatcher;
import by.epam.info_handling.main.controller.ControllerEnum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketHandler {

    public static final SocketHandler instance = new SocketHandler();

    private SocketHandler(){}

    public static SocketHandler getInstance() {
        return instance;
    }

    public int handleSocket(Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String request = reader.readLine();

        if(request == null) {
            return -1;
        }

        if(request.equals("stop")) {
            return 0;
        }

        for(ControllerEnum element: ControllerEnum.values()) {
            if(request.matches(String.format("^%s/.*", element))) {
                ControllerDispatcher
                        .getInstance()
                        .getController(element)
                        .service(socket.getInputStream(), socket.getOutputStream());
                return 1;
            }
        }

        return -1;
    }
}
