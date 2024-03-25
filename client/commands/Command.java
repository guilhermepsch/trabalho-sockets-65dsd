package trabalho.client.commands;

import java.io.BufferedReader;
import java.io.IOException;

public interface Command {
    String execute(BufferedReader userInputReader) throws IOException;
}
