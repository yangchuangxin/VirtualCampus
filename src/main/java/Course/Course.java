package Course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
    private long id = 0;
    private String courseName = "";
    private long teacherId = 0;
    private String teacherName = "";
    private Map<Integer, Integer> time = new HashMap<>(); //返回克隆对象
    private String classroom = "";
    private String semester = "";
    private double credit = 0.0;
    private String institute = "";
    private List<Integer> students = new ArrayList<>(); //返回克隆对象，确保安全

    public Course() {
    }

    public Course(String str) {
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

    private void setField(String fieldName, String fieldValue) {
        switch (fieldName) {
            case "id":
                setId(Long.parseLong(fieldValue));
                break;
            case "courseName":
                setCourseName(fieldValue);
                break;
            case "teacherId":
                setTeacherId(Long.parseLong(fieldValue));
                break;
            case "teacherName":
                setTeacherName(fieldValue);
                break;
            case "time":
                setTime(fieldValue);
                break;
            case "classroom":
                setClassroom(fieldValue);
                break;
            case "semester":
                setSemester(fieldValue);
                break;
            case "credit":
                setCredit(Double.parseDouble(fieldValue));
                break;
            case "institute":
                setInstitute(fieldValue);
                break;
            case "students":

            default:
                break;
        }
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setTime(String str) {
        int i = 1, j = 1, n = str.length() - 1;
        Integer key;
        Integer value;
        while (j < n) {
            while (j < n && str.charAt(j) != '=') ++j;
            key = Integer.parseInt(str.substring(i, j));
            i = ++j;
            while (j < n && str.charAt(j) != ',') ++j;
            value = Integer.parseInt(str.substring(i, j));
            ++j;
            i = ++j;
            time.put(key, value);
        }
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public void setStudents(List<Integer> students) {
        this.students = new ArrayList<>(students);
    }

    public void setStudents(String str){
        int i = 1, j = 1, n = str.length() - 1;
        while(j < n){
            while(j < n && str.charAt(j) != ',') ++j;
            students.add(Integer.parseInt(str.substring(i, j)));
            ++j;
            i = ++j;
        }
    }

    public long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public Map<Integer, Integer> getTime() {
        return new HashMap<>(time);
    }

    public String getClassroom() {
        return classroom;
    }

    public String getSemester() {
        return semester;
    }

    public double getCredit() {
        return credit;
    }

    public String getInstitute() {
        return institute;
    }

    public List<Integer> getStudents() {
        return new ArrayList<>(this.students);
    }

    @Override
    public String toString() {

        StringBuilder ret = new StringBuilder();
        ret.append("id:").append(getId())
                .append(";courseName:").append(getCourseName())
                .append(";teacherId:").append(getTeacherId())
                .append(";teacherName:").append(getTeacherName())
                .append(";time:").append(getTime())
                .append(";classroom:").append(getClassroom())
                .append(";semester:").append(getSemester())
                .append(";credit:").append(getCredit())
                .append(";institute:").append(getInstitute())
                .append(";students:").append(getStudents())
                .append(";");
        return ret.toString();
    }
}
