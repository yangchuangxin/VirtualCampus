package database.CourseDb;

import Course.Course;
import database.BasicDbOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDb extends BasicDbOperation {

    public CourseDb() {
        super("/Users/zhangminxue/Desktop/CourseDb.accdb", "course");
    }

    public CourseDb(String dbPath, String tableName) {
        super(dbPath, tableName);
    }


    public void add(Course crs) throws SQLException {

        Connection conn = getConn();

        String sql = "INSERT INTO " + tableName + " (id, courseName, teacherId, teacherName, " +
                "time, classroom, semester, credit, institute, students) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        ////////////////////?????????????????????
        ////////////////////?????????????????????
        ////////////////////?????????????????????
        pstmt.setString(1, "" + crs.getId());
        pstmt.setString(2, crs.getCourseName());
        pstmt.setString(3, "" + crs.getTeacherId());
        pstmt.setString(4, crs.getTeacherName());
        pstmt.setString(5, crs.getTime().toString());
        pstmt.setString(6, crs.getClassroom());
        pstmt.setString(7, crs.getSemester());
        pstmt.setString(8, "" + crs.getCredit());
        pstmt.setString(9, crs.getInstitute());
        pstmt.setString(10, crs.getStudents().toString());
        pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();
        rs.next();

        ////////////////////?????????????????????/
        // ////////////////////?????????????????????
        // ////////////////////?????????????????????
        // ////////////////////?????????????????????/////////////?????????????????????////////////////////?????????????????????
        crs.setId(rs.getLong(1));

        pstmt.close();
        conn.close();
    }

    /**
     * 根据学生 id 更新学生信息
     *
     * @param crs 更新后的学生信息(id 未改变)
     */
    /*private long id = 0;  //整数
    private String courseName = ""; //短文本
    private long teacherId = 0; //整数
    private String teacherName = ""; //短文本
    private Map<> time = 0; //短文本
    private String classroom = ""; //短文本
    private String semester = ""; //短文本
    private double credit = 0.0; //小数
    private String institute = ""; //短文本
    private List<Integer> students = new ArrayList<>();*/ //长文本
    public void modify(Course crs) throws SQLException {

        Connection conn = getConn();

        String sql = "UPDATE " + tableName
                + "', courseName='" + crs.getCourseName()
                + "', teacherId='" + crs.getTeacherId()
                + "', teacherName='" + crs.getTeacherName()
                + "', time='" + crs.getTime()
                + "', classroom='" + crs.getClassroom()
                + "', semester='" + crs.getSemester()
                + "', credit='" + crs.getCredit()
                + "', institute='" + crs.getInstitute()
                + " SET students='" + crs.getStudents()
                + "' WHERE id='" + crs.getId() + "'";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }

    /**
     * 删除对应学生
     *
     * @param course 具体学生
     */
    public void delete(Course course) throws SQLException {
        delete(course.getId());
    }

}
