package trabalho.client.commands.hospital;

import trabalho.client.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class HospitalGetCommand implements Command {
    @Override
    public String execute(BufferedReader userInputReader) throws IOException {
        System.out.println("Insira o nome do hospital:");
        String nome = userInputReader.readLine();
        return ("GET_HOSPITAL;" + nome);
    }
}
