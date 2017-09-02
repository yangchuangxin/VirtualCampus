import server.Server;

import java.io.IOException;
import java.sql.SQLException;
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        //MyThread myThread = new MyThread();
        //myThread.start();

        //private ServerSocket server;
        //ServerSocket server = new ServerSocket(8080);
        //new ServerEntity(server);
        new Server(10086);

        //Student stu = new Student();
        //stu.setId(3).setCourseName("邹家伦").setAge("66").setSex("女")
        //        .setMailbox("").setPassword("");
        //Client client = new Client(10086);
        //client.msg = stu.toString();
        //client.operate = 1;
        //client.tableName = 1;
        //client.createMessage();
        //Person stu = new Student();
        //stu.setId("").setPassword()
        //Person person = new Person();
        //Person ps = new Person();
        //System.out.println(stu);
        //String str = stu.toString();
        //int n = str.length();
        //System.out.println(str.substring(n, n));
        //StudentDB.getConn();
        //StudentDB.addNewStudent(stu);
        //StudentDB.updateStudentInfm(stu);
        //StudentDB.delete(5);
    }
}
