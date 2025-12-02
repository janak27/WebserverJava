package com.janak.SingleThreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Server {

    public void run() throws IOException {
        int port = 8010;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started. Listening on port " + port);

        while (true) {
            Socket acceptedConnection = serverSocket.accept();
            System.out.println("Connection accepted from " + acceptedConnection.getRemoteSocketAddress());

            PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));

            // Read message from client
            String message = fromClient.readLine();
            System.out.println("Received from client: " + message);

            // Send response to client
            toClient.println("hello from server");
            toClient.flush();  // VERY IMPORTANT

            // Close resources
            fromClient.close();
            toClient.close();
            acceptedConnection.close();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
