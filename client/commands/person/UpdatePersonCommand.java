package trabalho.client.commands.person;

import trabalho.client.commands.AbstractRequestCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class UpdatePersonCommand extends AbstractRequestCommand {
    @Override
    public void execute(Socket socket, PrintWriter writer, BufferedReader reader, BufferedReader userInputReader) throws IOException {
        System.out.println("Enter CPF of the person to update:");
        String cpf = userInputReader.readLine();
        System.out.println("Enter updated name:");
        String name = userInputReader.readLine();
        System.out.println("Enter updated address:");
        String address = userInputReader.readLine();
        writer.println("UPDATE_PERSON;" + cpf + ";" + name + ";" + address);
        super.execute(socket, writer, reader, userInputReader);
    }
}
