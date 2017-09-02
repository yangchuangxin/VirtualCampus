package server;

import java.sql.SQLException;

class Interpreter {

    public static class Operate{
        static final int ADD = 1;
        static final int DELETE = 2;
         static final int MODIFY = 3;
         static final int FIND = 4;
    }

    public static class Table{
        static final int DB_STUDENT = 1;
        static final int DB_TEACHER = 2;
        static final int DB_ADMINISTRATOR = 3;
        static final int DB_COURSE = 4;
    }

    private int operate, tableName;
    private String objMsg; //操作，数据库信息，对象信息
    private String returnMsg;

    /**
     *
     * @param msg 1 1 stu.toString
     */
    Interpreter(String msg) {
        int i = 0, j = 0;
        while (msg.charAt(j) != '&') ++j;
        System.out.println(msg.substring(i, j));
        operate = Integer.parseInt(msg.substring(i, j));
        i = ++j;
        while (msg.charAt(j) != '&') ++j;
        tableName = Integer.parseInt(msg.substring(i, j));
        i = ++j;
        objMsg = msg.substring(i);
    }

    void execute() throws SQLException {
        Executor executor = new Executor();
        switch (tableName) {
            case Table.DB_STUDENT:
                executor.updateStudentDb(operate, objMsg);
                break;
            case Table.DB_TEACHER:
                executor.updateTeacherDb(operate, objMsg);
                break;
            case Table.DB_ADMINISTRATOR:
                executor.updateAdministratorDb(operate, objMsg);
                break;
            case Table.DB_COURSE:
                executor.updateCourseDb(operate, objMsg);
                break;
            default:
                break;
        }
        returnMsg = "true";
    }



    String getReturnMsg() {
        return returnMsg;
    }








}
