package cllient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    private int port;
    private Socket server;
    private String returnMsg;

    public Client(int port) throws IOException, InterruptedException {
        this.port = port;
        server = new Socket(InetAddress.getLocalHost(), port);
    }

    public void sendMsg(String msg) throws IOException {

        DataInputStream in = new DataInputStream(server.getInputStream());
        DataOutputStream out = new DataOutputStream(server.getOutputStream());

        out.writeUTF(msg);

        returnMsg = in.readUTF();

        server.close();
    }

    /**
     * 返回值？
     */
    public Client setPort(int port) {
        this.port = port;
        return this;
    }

    public int getPort() {
        return port;
    }

    public String getReturnMsg() {
        return returnMsg;
    }
}
