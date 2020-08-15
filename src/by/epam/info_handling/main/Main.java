package by.epam.info_handling.main;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080);
             Socket socket = serverSocket.accept()) {

            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            int status;
            while ((status = SocketHandler.getInstance().handleSocket(socket)) != 0) {

                if(!socket.isConnected()) {
                    socket = serverSocket.accept();
                }

                if (status == -1) {
                    writer.println("no such controller");
                    writer.flush();
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
