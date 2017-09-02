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
        Interpreter interpreter = new Interpreter(str);
        interpreter.execute();
        return interpreter.getReturnMsg();
    }

    public void run() {
        try {
            DataInputStream in = new DataInputStream(client.getInputStream());
            //ObjectInputStream inputStream = new ObjectInputStream(client.getInputStream());
            //inputStream.readObject();
            //ObjectOutputStream outputStream = new ObjectOutputStream(client.getOutputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            while (true) {

                String str;
                str = in.readUTF();
                System.out.println(str);
                if (str.equals("end"))
                    break;
                String ret = interpret(str);

                out.writeUTF(ret);
                //System.out.println(1);
                //Student stu = (Student)inputStream.readObject();
                //System.out.println(stu.toString());


            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
