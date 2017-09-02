package cllient;

public class Compiler {

    public static class Operate{
        public static final int ADD = 1;
        public static final int DELETE = 2;
        public static final int MODIFY = 3;
        public static final int FIND = 4;
    }

    public static class Table{
        static final int DB_STUDENT = 1;
        static final int DB_TEACHER = 2;
        static final int DB_ADMINISTRATOR = 3;
        static final int DB_COURSE = 4;
    }

    private int operate;
    private int tableName;
    private String infm;

    public Compiler(int operate, int tableName, String infm){
        this.operate = operate;
        this.tableName = tableName;
        this.infm =infm;
    }

    public void setOperate(int operate) {
        this.operate = operate;
    }

    public void setTableName(int tableName) {
        this.tableName = tableName;
    }

    public void setInfm(String infm) {
        this.infm = infm;
    }

    public int getOperate() {
        return operate;
    }

    public int getTableName() {
        return tableName;
    }

    public String getInfm() {
        return infm;
    }

    public String createMessage() {
        return operate + "&" + tableName + "&" + infm;
    }
}
