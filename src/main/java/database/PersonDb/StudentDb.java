package database.PersonDb;

import user.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDb extends PersonDb {

    //public static String dbName = "PersonDb";
    //public static String tableName = "stuent";


    //private String dbName = "StudentDB";
    //private String tableName = "student";
    //private String dbPath = "/Users/zhangminxue/Desktop/PersonDb.accdb";

    public StudentDb() {
        super("/Users/zhangminxue/Desktop/PersonDb.accdb", "student");
    }

    public StudentDb(String dbPath, String tableName) {
        super(dbPath, tableName);
    }

    /**
     * 添加新学生，id 自动生成
     *
     * @param stu 待添加的学生
     */
    public void add(Student stu) throws SQLException {

        Connection conn = getConn();

        String sql = "INSERT INTO " + tableName + " (name, sex, age, cardNumber, " +
                "password, telephone, mailbox, institute, studentNumber, startYear) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, stu.getName());
        pstmt.setString(2, stu.getSex());
        pstmt.setString(3, stu.getAge());
        pstmt.setString(4, stu.getCardNumber());
        pstmt.setString(5, stu.getPassword());
        pstmt.setString(6, stu.getTelephone());
        pstmt.setString(7, stu.getMailbox());
        pstmt.setString(8, stu.getInstitute());
        pstmt.setString(9, stu.getStudentNumber());
        pstmt.setString(10, stu.getStartYear());
        pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();
        rs.next();
        stu.setId(rs.getLong(1));

        pstmt.close();
        conn.close();
    }

    /**
     * 根据学生 id 更新学生信息
     *
     * @param stu 更新后的学生信息(id 未改变)
     */
    public void modify(Student stu) throws SQLException {

        Connection conn = getConn();

        String sql = "UPDATE " + tableName + " SET name='" + stu.getName()
                + "', sex='" + stu.getSex() + "', age='" + stu.getAge()
                + "', cardNumber='" + stu.getCardNumber() + "', password='" + stu.getPassword()
                + "', telephone='" + stu.getTelephone() + "', mailbox='" + stu.getMailbox()
                + "', institute='" + stu.getInstitute()
                + "', studentNumber='" + stu.getStudentNumber()
                + "', startYear='" + stu.getStartYear()
                + "' WHERE id='" + stu.getId() + "'";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }
}
