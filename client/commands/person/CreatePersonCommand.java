package trabalho.client.commands.person;

import trabalho.client.commands.AbstractRequestCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class CreatePersonCommand extends AbstractRequestCommand {
    @Override
    public void execute(Socket socket, PrintWriter writer, BufferedReader reader, BufferedReader userInputReader) throws IOException {
        System.out.println("Enter CPF:");
        String cpf = userInputReader.readLine();
        System.out.println("Enter Name:");
        String name = userInputReader.readLine();
        System.out.println("Enter Address:");
        String address = userInputReader.readLine();
        writer.println("CREATE_PERSON;" + cpf + ";" + name + ";" + address);
        super.execute(socket, writer, reader, userInputReader);
    }
}
