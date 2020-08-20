package by.epam.info_handling.web;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            serverSocket.setSoTimeout(60 * 1000);

            while(true) {
                Socket socket = serverSocket.accept();
                SocketHandler.getInstance().handleSocket(socket);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
