package server;

import database.PersonDB.AdministratorDb;
import database.PersonDB.StudentDb;
import database.PersonDB.TeacherDb;
import user.Administrator;
import user.Student;
import user.Teacher;

import java.sql.SQLException;

class Interpreter {
    private int operate, tableName;
    private String objMsg; //操作，数据库信息，对象信息
    private String returnMsg;

    Interpreter(String msg) {
        int i = 0, j = 0;
        while (msg.charAt(j) != ' ') ++j;
        System.out.println(msg.substring(i, j));
        operate = Integer.parseInt(msg.substring(i, j));
        i = ++j;
        while (msg.charAt(j) != ' ') ++j;
        tableName = Integer.parseInt(msg.substring(i, j));
        i = ++j;
        objMsg = msg.substring(i);
    }

    void execute() throws SQLException {
        //Object obj;
        switch (tableName) {
            case Server.DB_STUDENT:
                updateStudentDb();
                break;
            case Server.DB_TEACHER:
                updateTeacherDb();
                break;
            case Server.DN_ADMINISTRATOR:
                updateAdministratorDb();
                break;
            default:
                break;
        }
        returnMsg = "true";
    }

    String getReturnMsg() {
        return returnMsg;
    }

    private void updateStudentDb() throws SQLException {
        StudentDb studentDb = new StudentDb();
        switch (operate) {
            case Server.ADD:
                studentDb.add(new Student(objMsg));
                break;
            case Server.DELETE:
                studentDb.delete(new Student(objMsg));
                break;
            case Server.MODIFY:
                studentDb.modify(new Student(objMsg));
                break;
            //case 4:studentDb.find()
        }
    }

    private void updateTeacherDb() throws SQLException {
        TeacherDb teacherDb = new TeacherDb();
        switch (operate) {
            case Server.ADD:
                teacherDb.add(new Teacher(objMsg));
                break;
            case Server.DELETE:
                teacherDb.delete(new Teacher(objMsg));
                break;
            case Server.MODIFY:
                teacherDb.modify(new Teacher(objMsg));
                break;
            //case 4:studentDb.find()
        }
    }

    private void updateAdministratorDb() throws SQLException {
        AdministratorDb administratorDb = new AdministratorDb();
        switch (operate) {
            case Server.ADD:
                administratorDb.add(new Administrator(objMsg));
                break;
            case Server.DELETE:
                administratorDb.delete(new Administrator(objMsg));
                break;
            case Server.MODIFY:
                administratorDb.modify(new Administrator(objMsg));
                break;
            //case 4:studentDb.find()
        }
    }


}
