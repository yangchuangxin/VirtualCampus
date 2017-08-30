package server;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public Client() throws IOException {

        Socket server = new Socket(InetAddress.getLocalHost(), 8080);
        DataInputStream in = new DataInputStream(server.getInputStream());
        DataOutputStream out = new DataOutputStream(server.getOutputStream());

        while(true){

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();

            out.writeUTF(s);

            String str = in.readUTF();
            System.out.println(str);

            if(str.equals("end"))
                break;
        }
        server.close();
    }
}
