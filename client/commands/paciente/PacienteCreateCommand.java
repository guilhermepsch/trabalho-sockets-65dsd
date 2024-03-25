package trabalho.client.commands.paciente;

import trabalho.client.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;

public class PacienteCreateCommand implements Command {
    @Override
    public String execute(BufferedReader userInputReader) throws IOException {
        System.out.println("Inserir CPF:");
        String cpf = userInputReader.readLine();
        System.out.println("Inserir nome:");
        String name = userInputReader.readLine();
        System.out.println("Inserir endereço:");
        String address = userInputReader.readLine();
        System.out.println("Inserir histórico médico:");
        String historico = userInputReader.readLine();
        return ("CREATE_PACIENTE;" + cpf + ";" + name + ";" + address + ";" + historico);
    }
}
