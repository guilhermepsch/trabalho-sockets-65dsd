package trabalho.client.commands.medico;

import trabalho.client.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;

public class MedicoCreateCommand implements Command {
    @Override
    public String execute(BufferedReader userInputReader) throws IOException {
        System.out.println("Inserir CPF:");
        String cpf = userInputReader.readLine();
        System.out.println("Inserir nome:");
        String name = userInputReader.readLine();
        System.out.println("Inserir endereço:");
        String address = userInputReader.readLine();
        System.out.println("Inserir especialização:");
        String special = userInputReader.readLine();
        return ("CREATE_MEDICO;" + cpf + ";" + name + ";" + address + ";" + special);
    }
}
