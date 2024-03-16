package trabalho.client.commands.person;

import trabalho.client.commands.AbstractRequestCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class DeletePersonCommand extends AbstractRequestCommand {
    @Override
    public void execute(Socket socket, PrintWriter writer, BufferedReader reader, BufferedReader userInputReader) throws IOException {
        System.out.println("Enter CPF of the person to delete:");
        String cpf = userInputReader.readLine();
        writer.println("DELETE_PERSON;" + cpf);
        super.execute(socket, writer, reader, userInputReader);
    }
}
