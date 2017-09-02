package Subject;

import java.lang.reflect.Field;

public class Subject {
    private long id;
    private String name;
    private long teacherId;
    private String teacherName;
    private int time;
    private String classroom;
    private String semester;
    private double credit;

    public Subject() {
        id = 0;
        name = "";
        teacherId = 0;
        teacherName = "";
        time = 0;
        classroom = "";
        semester = "";
        credit = 0.0;
    }

    public Subject(String str) {
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
            case "name":
                setName(fieldValue);
                break;
            case "teacherId":
                setTeacherId(Long.parseLong(fieldValue));
                break;
            case "teacherName":
                setTeacherName(fieldValue);
                break;
            case "time":
                setTime(Integer.parseInt(fieldValue));
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
            default:
                break;
        }
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setTime(int time) {
        this.time = time;
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

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public int getTime() {
        return time;
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

    @Override
    public String toString() {

        StringBuilder ret = new StringBuilder();
        ret.append(super.toString());

        Class cls = this.getClass();
        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            try {
                ret.append(field.getName()).append(":").
                        append(field.get(this)).append(";");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return ret.toString();
    }
}
