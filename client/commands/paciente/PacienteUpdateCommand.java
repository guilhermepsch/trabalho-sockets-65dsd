package trabalho.client.commands.paciente;

import trabalho.client.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;

public class PacienteUpdateCommand implements Command {
    @Override
    public String execute(BufferedReader userInputReader) throws IOException {
        System.out.println("Insira o CPF do paciente a ser atualizado:");
        String cpf = userInputReader.readLine();
        System.out.println("Insira o novo nome:");
        String name = userInputReader.readLine();
        System.out.println("Insira o novo endereço:");
        String address = userInputReader.readLine();
        System.out.println("Insira o novo histórico médico:");
        String historicoMedico = userInputReader.readLine();
        return ("UPDATE_PACIENTE;" + cpf + ";" + name + ";" + address + ";" + historicoMedico);
    }
}
