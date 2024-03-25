package trabalho.client.commands.hospital;

import trabalho.client.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;

public class HospitalDeleteCommand implements Command {
    @Override
    public String execute(BufferedReader userInputReader) throws IOException {
        System.out.println("Insira o nome do hospital a ser deletado:");
        String nome = userInputReader.readLine();
        return ("DELETE_HOSPITAL;" + nome);
    }
}
