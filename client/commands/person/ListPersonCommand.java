package trabalho.client.commands.person;

import trabalho.client.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ListPersonCommand implements Command {
    @Override
    public void execute(Socket socket, PrintWriter writer, BufferedReader reader, BufferedReader userInputReader) throws IOException {
        writer.println("LIST_PERSON");

        String response;
        System.out.println("Server Response:");
        while ((response = reader.readLine()) != null) {
            if (response.equals("END_OF_MESSAGE")) {
                break;
            }
            if (response.isEmpty()){
                continue;
            }
            System.out.println(response);
        }
    }
}
