package user;

/**
 * Created by John on 2017/8/30 0030.
 */
public class Teacher extends Person {
    public static int ENCODING = 2;
    private String institute;

    public Teacher() {
        super();
        institute = "";
    }

    public Teacher(String str) {
        int i = 0, j = 0, n = str.length();
        String fieldName, fieldValue;
        while (j < n) {
            while (str.charAt(j) != '：') ++j;
            fieldName = str.substring(i, j);
            i = ++j;
            while (str.charAt(j) != ';') ++j;
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
            default:
                super.setField(fieldName, fieldValue);
                break;
        }
    }

    public Teacher setInstitute(String institute) {
        this.institute = institute;
        return this;
    }

    public String getInstitute() {
        return institute;
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
