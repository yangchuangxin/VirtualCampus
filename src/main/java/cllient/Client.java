package cllient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public static int ADD = 1;
    public static int DELETE = 2;
    public static int MODIFY = 3;
    public static int FIND = 4;

    private int operate;
    private int tableName;
    private String Infm;

    private boolean ok;
    private int port;

    public Client(int port) throws IOException, InterruptedException {
        this.port = port;
    }

    public String createMessage() {
        return "" + operate + " " + tableName + " " + Infm + "\n";
    }

    /**
     * 返回值？
     */
    public void sendMessage() throws IOException, InterruptedException {
        connect();
    }

    private void connect() throws IOException, InterruptedException {

        Socket server = new Socket(InetAddress.getLocalHost(), port);
        DataInputStream in = new DataInputStream(server.getInputStream());
        DataOutputStream out = new DataOutputStream(server.getOutputStream());

        //while (true) {

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String s = br.readLine();

        out.writeUTF(createMessage());



        String str = in.readUTF();
        System.out.println(str);

        //   if (str.equals("end"))
        //       break;

        server.close();
    }

    public Client setPort(int port) {
        this.port = port;
        return this;
    }

    public Client setOperate(int operate) {
        this.operate = operate;
        return this;
    }

    public Client setTableName(int tableName) {
        this.tableName = tableName;
        return this;
    }

    public Client setInfm(String Infm) {
        this.Infm = Infm;
        return this;
    }

    public int getPort() {
        return port;
    }

    public int getOperate() {
        return operate;
    }

    public int getTableName() {
        return tableName;
    }

    public String getInfm() {
        return Infm;
    }
}
