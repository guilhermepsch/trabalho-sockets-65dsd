package trabalho.client.commands.paciente;

import trabalho.client.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;

public class PacienteGetCommand implements Command {
    @Override
    public String execute(BufferedReader userInputReader) throws IOException {
        System.out.println("Insira o CPF do paciente para ler:");
        String cpf = userInputReader.readLine();
        return ("GET_PACIENTE;" + cpf);
    }
}
