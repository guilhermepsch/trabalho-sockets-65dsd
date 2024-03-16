package trabalho.client.commands.pessoa;

import trabalho.client.commands.AbstractRequestCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class PessoaDeleteCommand extends AbstractRequestCommand {
    @Override
    public void execute(Socket socket, PrintWriter writer, BufferedReader reader, BufferedReader userInputReader) throws IOException {
        System.out.println("Insira o CPF da pessoa para ser deletada:");
        String cpf = userInputReader.readLine();
        writer.println("DELETE_PESSOA;" + cpf);
        super.execute(socket, writer, reader, userInputReader);
    }
}
