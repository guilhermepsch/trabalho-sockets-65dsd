package trabalho.client.commands.pessoa;

import trabalho.client.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;

public class PessoaListCommand implements Command {
    @Override
    public String execute(BufferedReader userInputReader) throws IOException {
        return ("LIST_PESSOA");
    }
}
