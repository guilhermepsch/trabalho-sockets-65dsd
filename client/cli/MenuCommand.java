package trabalho.client.cli;

import trabalho.client.commands.Command;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

abstract public class MenuCommand implements Command {
    protected final List<MenuItem> menuItems = new ArrayList<>();

    @Override
    public void execute(Socket socket, PrintWriter writer, BufferedReader reader, BufferedReader userInputReader) throws IOException {
        String userInput;
        while (true) {
            showMenu();
            userInput = userInputReader.readLine();
            if (userInput.equalsIgnoreCase("0")) {
                break;
            }
            MenuItem menuItem = findMenuItem(userInput);
            if (menuItem == null) {
                System.out.println("Invalid command. Please try again.");
                continue;
            }
            menuItem.getCommand().execute(socket, writer, reader, userInputReader);
        }
    }

    private MenuItem findMenuItem(String userInput) {
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getKey().equalsIgnoreCase(userInput)) {
                return menuItem;
            }
        }
        return null;
    }

    private void showMenu() {
        initialOptions();
        showOperations();
        askInput();
    }

    abstract protected String getMenuTitle();

    private void initialOptions() {
        System.out.println(this.getMenuTitle());
        System.out.println("0 - Back");
    }

    private void showOperations() {
        for (MenuItem menuItem : menuItems) {
            System.out.println(menuItem.getKey() + " - " + menuItem.getLabel());
        }
    }
    private void askInput() {
        System.out.print("Enter option number: ");
    }

    protected void addMenuItem(String key, String label, Command command) {
        menuItems.add(new MenuItem(key, label, command));
    }
}