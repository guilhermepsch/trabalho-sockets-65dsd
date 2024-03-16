package trabalho.server;

import trabalho.server.services.Server;

public class App {

    public static void main(String[] args) {
        Server server = Server.getInstance();
        server.start(3000);
    }

}
