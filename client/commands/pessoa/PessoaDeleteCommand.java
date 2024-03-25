package trabalho.client.commands.pessoa;

import trabalho.client.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;

public class PessoaDeleteCommand implements Command {
    @Override
    public String execute(BufferedReader userInputReader) throws IOException {
        System.out.println("Insira o CPF da pessoa para ser deletada:");
        String cpf = userInputReader.readLine();
        return ("DELETE_PESSOA;" + cpf);
    }
}
