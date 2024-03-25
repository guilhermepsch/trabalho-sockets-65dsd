package trabalho.client.commands.medico;

import trabalho.client.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;

public class MedicoListCommand implements Command {
    @Override
    public String execute(BufferedReader userInputReader) throws IOException {
        return ("LIST_MEDICO");
    }
}
