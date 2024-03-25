package trabalho.client.commands.paciente;

import trabalho.client.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;

public class PacienteDeleteCommand implements Command {
    @Override
    public String execute(BufferedReader userInputReader) throws IOException {
        System.out.println("Insira o CPF do paciente a ser deletado:");
        String cpf = userInputReader.readLine();
        return ("DELETE_PACIENTE;" + cpf);
    }
}
