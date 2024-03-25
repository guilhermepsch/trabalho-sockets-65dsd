package trabalho.client.cli;

import trabalho.client.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public abstract class Menu {
    private static final BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
    private static String serverAddress;
    private static int serverPort;
    private final Map<String, MenuItem> options = new HashMap<>();

    static {
        readServerInformation();
    }

    private static void readServerInformation() {
        try {
            System.out.print("Enter server address: ");
            serverAddress = userInputReader.readLine();
            System.out.print("Enter server port: ");
            serverPort = Integer.parseInt(userInputReader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading server information: " + e.getMessage());
            System.exit(1);
        }
    }

    protected void addOption(String key, String description, Menu submenu) {
        options.put(key, new MenuItem(description, submenu));
    }

    protected void addOption(String key, String description, Command command) {
        options.put(key, new MenuItem(description, command));
    }

    protected abstract String getTitle();

    protected void displayOptions() {
        options.forEach((key, value) -> System.out.println(key + " - " + value.getDescription()));
        System.out.println("0 - Back");
    }

    protected void executeOption(String key) throws IOException {
        MenuItem menuItem = options.get(key);
        if (menuItem != null) {
            if (menuItem.isSubMenu()) {
                menuItem.getSubMenu().run();
            } else {
                executeCommand(menuItem.getCommand());
            }
        } else {
            System.out.println("Invalid option.");
        }
    }

    private void executeCommand(Command command) throws IOException {
        String operation = command.execute(userInputReader);
        try (Socket socket = new Socket(serverAddress, serverPort);
             PrintWriter socketWriter = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println("Connected to server.");
            socketWriter.println(operation);
            String response;
            System.out.println("Server Response:");
            while ((response = socketReader.readLine()) != null) {
                if (response.equals("END_OF_MESSAGE")) {
                    break;
                }
                if (!response.isEmpty()) {
                    System.out.println(response);
                }
            }
            System.out.println("Disconnected from server.");
        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        }
    }

    public void run() {
        String userInput;
        while (true) {
            System.out.println(getTitle());
            displayOptions();
            try {
                userInput = userInputReader.readLine();
                if (userInput.equals("0")) {
                    break;
                }
                executeOption(userInput);
            } catch (IOException e) {
                System.err.println("Error reading input: " + e.getMessage());
            }
        }
    }
}