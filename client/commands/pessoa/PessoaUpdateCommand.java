package trabalho.client.commands.pessoa;

import trabalho.client.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;

public class PessoaUpdateCommand implements Command {
    @Override
    public String execute(BufferedReader userInputReader) throws IOException {
        System.out.println("Insira o CPF da pessoa a ser atualizada:");
        String cpf = userInputReader.readLine();
        System.out.println("Insira o novo nome:");
        String name = userInputReader.readLine();
        System.out.println("Insira o novo endereço:");
        String address = userInputReader.readLine();
        return ("UPDATE_PESSOA;" + cpf + ";" + name + ";" + address);
    }
}
