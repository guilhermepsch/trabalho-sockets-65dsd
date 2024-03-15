package trabalho.server.services;

import trabalho.server.controllers.OperationController;

import java.io.*;
import java.net.*;
import java.util.Arrays;

public class Server {
    private static final String SHUTDOWN_MESSAGE = "SHUTDOWN";
    private ServerSocket serverSocket;

    public Server() {}

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

    private void handleClient(Socket socket) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        ) {
            String message;
            while ((message = reader.readLine()) != null) {
                if (message.equals(SHUTDOWN_MESSAGE)) {
                    shutdown();
                    return;
                } else {
                    handleMessage(message);
                }
            }
        } catch (IOException e) {
            System.err.println("Error handling client message: " + e.getMessage());
        }
    }

    private void handleMessage(String message) {
        String[] parts = message.split(";");
        if (parts.length >= 2) {
            String operationId = parts[0];
            String[] args = Arrays.copyOfRange(parts, 1, parts.length);
            OperationController.handleOperation(operationId, args);
        } else {
            System.err.println("Invalid message format: " + message);
        }
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
}