package server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    private ServerSocket serverSocket;
    private boolean status = true;
    private int port = 0;

    public Server(int port) throws IOException {
        this.port = port;
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        while (status) {
            ServerEntity serverEntity
                    = new ServerEntity(serverSocket.accept());

            serverEntity.start();
        }
    }

    public void end(){
        status = false;
    }
}
