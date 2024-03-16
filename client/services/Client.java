package trabalho.client.services;

import trabalho.client.factories.MainMenuCommandFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));

    public static void run() {
        String serverAddress = getServerAddress();
        int serverPort = getServerPort();
        connectToServer(serverAddress, serverPort);
    }

    private static String getServerAddress() {
        try {
            System.out.print("Enter server address: ");
            return userInputReader.readLine();
        } catch (IOException e) {
            System.err.println("Error reading server address: " + e.getMessage());
            return null;
        }
    }

    private static int getServerPort() {
        try {
            System.out.print("Enter server port: ");
            return Integer.parseInt(userInputReader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading server port: " + e.getMessage());
            return -1;
        }
    }

    private static void connectToServer(String serverAddress, int serverPort) {
        try (Socket socket = new Socket(serverAddress, serverPort);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println("Connected to server.");
            MainMenuCommandFactory mainMenu = new MainMenuCommandFactory();
            mainMenu.execute(socket, writer, reader, userInputReader);
        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        }
    }

    private static String showMainMenuAndGetInput() throws IOException {
        System.out.println("CONTEXTS");
        System.out.println("PERSON - Person operations");
        System.out.print("Enter command: ");
        return userInputReader.readLine();
    }
}