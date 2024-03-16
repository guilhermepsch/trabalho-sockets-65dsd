package trabalho.client.commands.turma;

import trabalho.client.commands.AbstractRequestCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class TurmaUpdateCommand extends AbstractRequestCommand {
    @Override
    public void execute(Socket socket, PrintWriter writer, BufferedReader reader, BufferedReader userInputReader) throws IOException {
        System.out.println("Insira a materia da turma a ser atualizada:");
        String materia = userInputReader.readLine();
        System.out.println("Insira uma lista de CPFs separados por vírgula(,):");
        String pessoaCpfList = userInputReader.readLine();
        writer.println("CREATE_TURMA;" + materia + ";" + pessoaCpfList);
        super.execute(socket, writer, reader, userInputReader);
    }
}
