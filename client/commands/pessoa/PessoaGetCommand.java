package trabalho.client.commands.pessoa;

import trabalho.client.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;

public class PessoaGetCommand implements Command {
    @Override
    public String execute(BufferedReader userInputReader) throws IOException {
        System.out.println("Insira o CPF da pessoa para ler:");
        String cpf = userInputReader.readLine();
        return ("GET_PESSOA;" + cpf);
    }
}
