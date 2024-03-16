package trabalho.client.commands.pessoa;

import trabalho.client.commands.AbstractRequestCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class PessoaUpdateCommand extends AbstractRequestCommand {
    @Override
    public void execute(Socket socket, PrintWriter writer, BufferedReader reader, BufferedReader userInputReader) throws IOException {
        System.out.println("Insira o CPF da pessoa a ser atualizada:");
        String cpf = userInputReader.readLine();
        System.out.println("Insira o novo nome:");
        String name = userInputReader.readLine();
        System.out.println("Insira o novo endereço:");
        String address = userInputReader.readLine();
        writer.println("UPDATE_PESSOA;" + cpf + ";" + name + ";" + address);
        super.execute(socket, writer, reader, userInputReader);
    }
}
