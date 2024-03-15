package trabalho.server;

import trabalho.server.controllers.OperationController;
import trabalho.server.services.Server;

public class App {

    public static void main(String[] args) {
        Server server = new Server();
        server.start(1234); // Start server on port 1234
    }

}
