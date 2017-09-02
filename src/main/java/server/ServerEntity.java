package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

class ServerEntity extends Thread {
    private Socket client;


    ServerEntity(Socket c) throws IOException {
        client = c;
    }


    private String interpret(String str) throws SQLException {
        Interpreter Interpreter = new Interpreter(str);
        Interpreter.execute();
        return Interpreter.getReturnMsg();
    }

    public void run() {
        try {
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            while (true) {

                String str;
                str = in.readUTF();
                System.out.println(str);
                if (str.equals("end"))
                    break;
                String ret = interpret(str);

                out.writeUTF(ret);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
