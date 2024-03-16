package trabalho.client.commands.turma;

import trabalho.client.commands.AbstractRequestCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class TurmaDeleteCommand extends AbstractRequestCommand {
    @Override
    public void execute(Socket socket, PrintWriter writer, BufferedReader reader, BufferedReader userInputReader) throws IOException {
        System.out.println("Enter materia of the turma to be deleted:");
        String materia = userInputReader.readLine();
        writer.println("DELETE_TURMA;" + materia);
        super.execute(socket, writer, reader, userInputReader);
    }
}
