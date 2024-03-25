package trabalho.client.commands.medico;

import trabalho.client.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;

public class MedicoGetCommand implements Command {
    @Override
    public String execute(BufferedReader userInputReader) throws IOException {
        System.out.println("Insira o CPF do médico para ler:");
        String cpf = userInputReader.readLine();
        return ("GET_MEDICO;" + cpf);
    }
}
