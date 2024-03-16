package trabalho.client.commands.turma;

import trabalho.client.commands.AbstractRequestCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class TurmaListCommand extends AbstractRequestCommand {
    @Override
    public void execute(Socket socket, PrintWriter writer, BufferedReader reader, BufferedReader userInputReader) throws IOException {
        writer.println("LIST_TURMA");
        super.execute(socket, writer, reader, userInputReader);
    }
}
