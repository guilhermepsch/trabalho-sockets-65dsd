package trabalho.server.services;

import java.io.*;
import java.net.*;
import java.util.Arrays;

public class Server {
    private static Server instance;
    private ServerSocket serverSocket;

    private Server() {
    }

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server listening on port " + port);
            listenForClients();
        } catch (IOException e) {
            System.err.println("Error starting the server: " + e.getMessage());
        } finally {
            closeServerSocket();
        }
    }

    private void listenForClients() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                handleClient(socket);
            }
        } catch (IOException e) {
            System.err.println("Error accepting client connection: " + e.getMessage());
        }
    }

    private void handleClient(Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        String message;
        while ((message = reader.readLine()) != null) {
            try {
                System.out.println("Message Received (RAW):" + message);
                writer.println(handleMessage(message)+"\nEND_OF_MESSAGE");
            } catch (Exception e) {
                writer.println("Error handling client message: " + e.getMessage()+"\nEND_OF_MESSAGE");
            }
        }
    }

    private String handleMessage(String message) throws Exception {
        String[] parts = message.split(";");
        if (parts.length == 0) {
            throw new IOException("Invalid message format: " + message);
        }
        String operationId = parts[0];
        String[] args = Arrays.copyOfRange(parts, 1, parts.length);
        return OperationLocator.handleOperation(operationId, args);
    }

    private void shutdown() {
        System.out.println("Server shutting down...");
        closeServerSocket();
    }

    private void closeServerSocket() {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing server socket: " + e.getMessage());
        }
    }

    public static Server getInstance() {
        if (instance == null) {
            instance = new Server();
        }
        return instance;
    }
}