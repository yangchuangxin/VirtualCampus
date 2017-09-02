package server;

import Course.Course;
import database.CourseDb.CourseDb;
import database.PersonDb.AdministratorDb;
import database.PersonDb.StudentDb;
import database.PersonDb.TeacherDb;
import user.Administrator;
import user.Student;
import user.Teacher;

import java.sql.SQLException;

class Executor {
     void updateCourseDb(int operate, String objMsg) throws SQLException {
        CourseDb courseDb = new CourseDb();
        switch (operate) {
            case Interpreter.Operate.ADD:
                courseDb.add(new Course(objMsg));
                break;
            case Interpreter.Operate.DELETE:
                courseDb.delete(new Course(objMsg));
                break;
            case Interpreter.Operate.MODIFY:
                courseDb.modify(new Course(objMsg));
                break;
            //case 4:studentDb.find()
        }
    }

     void updateStudentDb(int operate, String objMsg) throws SQLException {
        StudentDb studentDb = new StudentDb();
        switch (operate) {
            case Interpreter.Operate.ADD:
                studentDb.add(new Student(objMsg));
                break;
            case Interpreter.Operate.DELETE:
                studentDb.delete(new Student(objMsg));
                break;
            case Interpreter.Operate.MODIFY:
                studentDb.modify(new Student(objMsg));
                break;
            //case 4:studentDb.find()
        }
    }

     void updateTeacherDb(int operate, String objMsg) throws SQLException {
        TeacherDb teacherDb = new TeacherDb();
        switch (operate) {
            case Interpreter.Operate.ADD:
                teacherDb.add(new Teacher(objMsg));
                break;
            case Interpreter.Operate.DELETE:
                teacherDb.delete(new Teacher(objMsg));
                break;
            case Interpreter.Operate.MODIFY:
                teacherDb.modify(new Teacher(objMsg));
                break;
            //case 4:studentDb.find()
        }
    }

     void updateAdministratorDb(int operate, String objMsg) throws SQLException {
        AdministratorDb administratorDb = new AdministratorDb();
        switch (operate) {
            case Interpreter.Operate.ADD:
                administratorDb.add(new Administrator(objMsg));
                break;
            case Interpreter.Operate.DELETE:
                administratorDb.delete(new Administrator(objMsg));
                break;
            case Interpreter.Operate.MODIFY:
                administratorDb.modify(new Administrator(objMsg));
                break;
            //case 4:studentDb.find()
        }
    }
}
