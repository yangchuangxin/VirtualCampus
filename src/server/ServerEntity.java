package server;

import java.io.*;
import java.net.Socket;

class ServerEntity extends Thread {
    private Socket client;


    ServerEntity(Socket c) throws IOException {
        client = c;
    }

    public void run() {
        try {
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            while (true) {

                String str;
                str = in.readUTF();
                System.out.println(str);

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String s = br.readLine();
                out.writeUTF(s);

                if (str.equals("end"))
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
