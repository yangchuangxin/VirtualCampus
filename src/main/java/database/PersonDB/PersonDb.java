package database.PersonDB;

import net.ucanaccess.jdbc.UcanaccessDriver;
import user.Person;

import java.sql.*;

public class PersonDb {

    String dbPath;
    String tableName;

    PersonDb(String dbPath, String tableName) {
        this.dbPath = dbPath;
        this.tableName = tableName;
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


    public ResultSet getSomeCol(String col, String cmd) throws SQLException {
        Connection conn = getConn();
        String sql = "select " + col + " from " + tableName + " " + cmd;
        ResultSet rs = null;

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
        } catch (SQLException var7) {
            var7.printStackTrace();
        }

        return rs;
    }

    public ResultSet getAllCol(String cmd) throws SQLException {
        return getSomeCol("*", cmd);
    }


    /**
     * 通过 id 删除学生
     *
     * @param id 学生 id
     */
    public void delete(long id) throws SQLException {

        Connection conn = getConn();

        String sql = "delete from " + tableName + " where id = '" + id + "'";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }

    /**
     * 删除对应学生
     *
     * @param person 具体学生
     */
    public void delete(Person person) throws SQLException {
        delete(person.getId());
    }
}
