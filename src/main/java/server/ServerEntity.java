package server;

import java.io.*;
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
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            while (true) {

                String str;
                str = in.readUTF();
                System.out.println(str);
                if (str.equals("end"))
                    break;
                String ret = interpret(str);

                /*
                处理请求
                */
                //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                //String s = br.readLine();
                out.writeUTF(ret);



            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }

}
