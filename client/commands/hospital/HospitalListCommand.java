package trabalho.client.commands.hospital;

import trabalho.client.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class HospitalListCommand implements Command {
    @Override
    public String execute(BufferedReader userInputReader) throws IOException {
        return ("LIST_HOSPITAL");
    }
}
