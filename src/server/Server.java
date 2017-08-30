package server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public Server(int port) throws IOException {

        ServerSocket serverSocket = new ServerSocket(port);

        while(true){
            ServerEntity serverEntity
                    = new ServerEntity(serverSocket.accept());

            serverEntity.start();
        }
    }
}
