package trabalho.client.commands.hospital;

import trabalho.client.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class HospitalUpdateCommand implements Command {
    @Override
    public String execute(BufferedReader userInputReader) throws IOException {
        System.out.println("Insira o nome do hospital a ser atualizado:");
        String nome = userInputReader.readLine();
        System.out.println("Insira uma lista de CPFs separados por vírgula(,):");
        String pessoaCpfList = userInputReader.readLine();
        return ("CREATE_HOSPITAL;" + nome + ";" + pessoaCpfList);
    }
}
