package trabalho.client.commands.person;

import trabalho.client.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class CreatePersonCommand implements Command {
    @Override
    public void execute(Socket socket, PrintWriter writer, BufferedReader reader, BufferedReader userInputReader) throws IOException {
        writer.println("CREATE_PERSON;09281019914;Guilherme;Av. Oscar Barcelos");
        String serverResponse = reader.readLine();
        System.out.println("Server response: " + serverResponse);
    }
}
