import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            ///加载驱动jar
            Class.forName("com.hxtt.sql.access.AccessDriver").newInstance();
            //指定Access数据库文件的位置
            String url = "jdbc:Access:///c:/a/db.mdb";
            //建立连接
            Connection conn = DriverManager.getConnection(url, "username", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
