package com.janak.MultiThreaded;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Runnable getRunnable(Socket clientSocket) {
        return () -> {
            try {
                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(), true);
                toClient.println("Hello from the server");
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    public static void main(String[] args) throws IOException {
        int port = 8010;
        Server server = new Server();

        // Bind port here
        ServerSocket serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);

        System.out.println("Multi server is listening on port : " + port);

        while (true) {
            Socket acceptedSocket = serverSocket.accept();
            Thread thread = new Thread(server.getRunnable(acceptedSocket));
            thread.start();
        }
    }
}
