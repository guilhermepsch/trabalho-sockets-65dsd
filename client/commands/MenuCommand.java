package trabalho.client.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

abstract public class MenuCommand implements Command {
    protected final Map<String, Command> menuCommands = new HashMap<>();

    @Override
    public void execute(Socket socket, PrintWriter writer, BufferedReader reader, BufferedReader userInputReader) throws IOException {
        String userInput;
        while (true) {
            showMenu();
            userInput = userInputReader.readLine();
            if (userInput.equalsIgnoreCase("0")) {
                break;
            }
            Command command = menuCommands.get(userInput.toUpperCase());
            if (command == null) {
                System.out.println("Invalid command. Please try again.");
                continue;
            }
            command.execute(socket, writer, reader, userInputReader);
        }
    }
    private void showMenu(){
        initialMessage();
        backOption();
        showOperations();
        askInput();
    }

    abstract protected void initialMessage();
    private void backOption(){
        System.out.println("0 - Back");
    };

    abstract protected void showOperations();

    private void askInput(){
        System.out.print("Enter option number: ");

    }

}
