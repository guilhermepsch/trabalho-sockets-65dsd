package trabalho.client.commands.paciente;

import trabalho.client.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;

public class PacienteListCommand implements Command {
    @Override
    public String execute(BufferedReader userInputReader) throws IOException {
        return ("LIST_PACIENTE");
    }
}
