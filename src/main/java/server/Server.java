package server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    static final int ADD = 1;
    static final int DELETE = 2;
    static final int MODIFY = 3;
    static final int FIND = 4;
    static final int DB_STUDENT = 1;
    static final int DB_TEACHER = 2;
    static final int DB_ADMINISTRATOR = 3;
    static final int DB_COURSE = 4;

    public Server(int port) throws IOException {

        ServerSocket serverSocket = new ServerSocket(port);

        while(true){
            ServerEntity serverEntity
                    = new ServerEntity(serverSocket.accept());

            serverEntity.start();
        }
    }
}
