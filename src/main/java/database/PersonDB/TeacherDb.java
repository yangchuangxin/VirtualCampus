package database.PersonDB;

import net.ucanaccess.jdbc.UcanaccessDriver;
import user.Teacher;

import java.sql.*;

public class TeacherDb extends PersonDb{

    public TeacherDb() {
        super("/Users/zhangminxue/Desktop/PersonDb.accdb", "teacher");
    }

    public TeacherDb(String dbPath, String tableName) {
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
     * @param teacher 待添加的学生
     */
    public void add(Teacher teacher) throws SQLException {

        Connection conn = getConn();

        String sql = "INSERT INTO " + tableName + " (name, sex, age, cardNumber, " +
                "password, telephone, mailbox, institute) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, teacher.getName());
        pstmt.setString(2, teacher.getSex());
        pstmt.setString(3, teacher.getAge());
        pstmt.setString(4, teacher.getCardNumber());
        pstmt.setString(5, teacher.getPassword());
        pstmt.setString(6, teacher.getTelephone());
        pstmt.setString(7, teacher.getMailbox());
        pstmt.setString(8, teacher.getInstitute());
        pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();
        rs.next();
        teacher.setId(rs.getLong(1));

        pstmt.close();
        conn.close();
    }

    /**
     * 根据学生 id 更新学生信息
     *
     * @param teacher 更新后的学生信息(id 未改变)
     */
    public void modify(Teacher teacher) throws SQLException {

        Connection conn = getConn();

        String sql = "UPDATE " + tableName + " SET name='" + teacher.getName()
                + "', sex='" + teacher.getSex() + "', age='" + teacher.getAge()
                + "', cardNumber='" + teacher.getCardNumber() + "', password='" + teacher.getPassword()
                + "', telephone='" + teacher.getTelephone() + "', mailbox='" + teacher.getMailbox()
                + "', institute='" + teacher.getInstitute()
                + "' WHERE id='" + teacher.getId() + "'";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }


}
