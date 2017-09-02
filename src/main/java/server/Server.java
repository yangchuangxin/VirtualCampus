package server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static final int ADD = 1;
    public static final int DELETE = 2;
    public static final int MODIFY = 3;
    public static final int FIND = 4;
    public static final int DB_STUDENT = 1;
    public static final int DB_TEACHER = 2;
    public static final int DN_ADMINISTRATOR = 3;

    public Server(int port) throws IOException {

        ServerSocket serverSocket = new ServerSocket(port);

        while(true){
            ServerEntity serverEntity
                    = new ServerEntity(serverSocket.accept());

            serverEntity.start();
        }
    }
}
