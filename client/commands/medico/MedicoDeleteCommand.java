package trabalho.client.commands.medico;

import trabalho.client.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;

public class MedicoDeleteCommand implements Command {
    @Override
    public String execute(BufferedReader userInputReader) throws IOException {
        System.out.println("Insira o CPF do médico a ser deletado:");
        String cpf = userInputReader.readLine();
        return ("DELETE_MEDICO;" + cpf);
    }
}
