package trabalho.client.commands.pessoa;

import trabalho.client.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;

public class PessoaCreateCommand implements Command {
    @Override
    public String execute(BufferedReader userInputReader) throws IOException {
        System.out.println("Inserir CPF:");
        String cpf = userInputReader.readLine();
        System.out.println("Inserir Name:");
        String name = userInputReader.readLine();
        System.out.println("Inserir endereço Address:");
        String address = userInputReader.readLine();
        return ("CREATE_PESSOA;" + cpf + ";" + name + ";" + address);
    }
}
