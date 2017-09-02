package user;

/**
 * Created by John on 2017/8/30 0030.
 */
public class Teacher extends Person {
    public static int ENCODING = 2;
    private String institute = "";
    private String startYear = "";
    private static final String[] fields = {"id", "name",
            "sex", "age", "cardNumber", "password", "telephone",
            "mailbox", "institute", "startYear"};

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
            case "startYear":
                setStartYear(fieldValue);
                break;
            default:
                super.setField(fieldName, fieldValue);
                break;
        }
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getInstitute() {
        return institute;
    }

    public String getStartYear() {
        return startYear;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append(super.toString());
        ret.append("institute:").append(getInstitute())
                .append(";startYear:").append(getStartYear())
                .append(";");
        return ret.toString();
    }
}
