package trabalho.client.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public abstract class AbstractRequestCommand implements Command {
    @Override
    public void execute(Socket socket, PrintWriter writer, BufferedReader reader, BufferedReader userInputReader) throws IOException {
        String response;
        System.out.println("Server Response:");
        while ((response = reader.readLine()) != null) {
            if (response.equals("END_OF_MESSAGE")) {
                break;
            }
            if (response.isEmpty()){
                continue;
            }
            System.out.println(response);
        }
    }
}