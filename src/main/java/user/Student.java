package user;

/**
 * Created by John on 2017/8/30 0030.
 */
public class Student extends Person {
    public static int ENCODING = 1;

    private String institute;
    private String studentNumber;
    private String startYear;

    public Student() {
        super();
        institute = "";
        studentNumber = createStudentNumber();
    }

    public Student(String str) {
        super();
        int i = 0, j = 0, n = str.length();
        while (str.charAt(n - 1) != ';') --n;
        String fieldName, fieldValue;
        while (j < n) {
            while (j < n && str.charAt(j) != ':') ++j;
            fieldName = str.substring(i, j);
            i = ++j;
            while (j < n && str.charAt(j) != ';') ++j;
            fieldValue = str.substring(i, j);
            i = ++j;
            setField(fieldName, fieldValue);
        }
    }

    void setField(String fieldName, String fieldValue) {
        switch (fieldName) {
            case "institute":
                setInstitute(fieldValue);
                break;
            case "studentNumber":
                setStudentNumber(fieldValue);
                break;
            default:
                super.setField(fieldName, fieldValue);
                break;
        }
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getStartYear() {
        return startYear;
    }

    public String getInstitute() {
        return institute;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    /**
     * 未完成
     *
     * @return
     */
    public String createStudentNumber() {
        return "";
    }

    @Override
    public String toString() {

        StringBuilder ret = new StringBuilder();
        ret.append(super.toString());

        Class cls = this.getClass();
        addFieldsToStringBuilder(cls.getDeclaredFields(), ret);

        return ret.toString();
    }
}
