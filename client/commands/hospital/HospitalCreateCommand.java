package trabalho.client.commands.hospital;

import trabalho.client.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class HospitalCreateCommand implements Command {
    @Override
    public String execute(BufferedReader userInputReader) throws IOException {
        System.out.println("Insira o nome do hospital a ser criado:");
        String nome = userInputReader.readLine();
        System.out.println("Insira o endereco do hospital a ser criado:");
        String endereco = userInputReader.readLine();
        System.out.println("Insira uma lista de CPFs de pessoas separadas por vírgula(,):");
        String pessoaCpfList = userInputReader.readLine();
        return ("CREATE_HOSPITAL;" + nome + ";" + endereco + ";" + pessoaCpfList);
    }
}
