package user;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by John on 2017/8/30 0030.
 */
public class Student extends Person {
    public static int ENCODING = 1;

    private String institute = "";
    private String studentNumber = "";
    private String startYear = "";
    private Map<Integer, Double> score = new HashMap<>();

    public Student() {
        super();
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
            case "startYear":
                setStartYear(fieldValue);
                break;
            case "score":
                setScore(fieldValue);
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

    /**
     * @param str {1=1.1, 2=2.2, 3=3.3}
     */
    public void setScore(String str) {
        int i = 1, j = 1, n = str.length() - 1;
        Integer key;
        Double value;
        while (j < n) {
            while (j < n && str.charAt(j) != '=') ++j;
            key = Integer.parseInt(str.substring(i, j));
            i = ++j;
            while (j < n && str.charAt(j) != ',') ++j;
            value = Double.parseDouble(str.substring(i, j));
            ++j;
            i = ++j;
            score.put(key, value);
        }
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

    public Map<Integer, Double> getScore() {
        return new HashMap<>(score);
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
        ret.append("institute:").append(getInstitute())
                .append(";studentNumber:").append(getStudentNumber())
                .append(";startYear:").append(getStartYear())
                .append(";score:").append(getScore())
                .append(";");
        return ret.toString();
    }
}
