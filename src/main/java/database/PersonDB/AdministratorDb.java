package database.PersonDB;

import net.ucanaccess.jdbc.UcanaccessDriver;
import user.Administrator;

import java.sql.*;

public class AdministratorDb extends PersonDb{

    public AdministratorDb() {
        super("/Users/zhangminxue/Desktop/PersonDb.accdb", "administrator");
    }

    public AdministratorDb(String dbPath, String tableName) {
        super(dbPath, tableName);
    }

    /**
     * 连接数据库
     *
     * @return 连接
     */
    public Connection getConn() throws SQLException {
        String url = UcanaccessDriver.URL_PREFIX + dbPath + ";newDatabaseVersion=V2007";
        return DriverManager.getConnection(url);
    }

    /**
     * 添加新学生，id 自动生成
     *
     * @param admin 待添加的学生
     */
    public void add(Administrator admin) throws SQLException {

        Connection conn = getConn();

        String sql = "INSERT INTO " + tableName + " (name, sex, age, cardNumber, " +
                "password, telephone, mailbox) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, admin.getName());
        pstmt.setString(2, admin.getSex());
        pstmt.setString(3, admin.getAge());
        pstmt.setString(4, admin.getCardNumber());
        pstmt.setString(5, admin.getPassword());
        pstmt.setString(6, admin.getTelephone());
        pstmt.setString(7, admin.getMailbox());
        pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();
        rs.next();
        admin.setId(rs.getLong(1));

        pstmt.close();
        conn.close();
    }

    /**
     * 根据学生 id 更新学生信息
     *
     * @param admin 更新后的学生信息(id 未改变)
     */
    public void modify(Administrator admin) throws SQLException {

        Connection conn = getConn();

        String sql = "UPDATE " + tableName + " SET name='" + admin.getName()
                + "', sex='" + admin.getSex() + "', age='" + admin.getAge()
                + "', cardNumber='" + admin.getCardNumber() + "', password='" + admin.getPassword()
                + "', telephone='" + admin.getTelephone() + "', mailbox='" + admin.getMailbox()
                + "' WHERE id='" + admin.getId() + "'";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }

}
