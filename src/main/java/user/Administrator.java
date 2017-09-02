package user;

/**
 * Created by John on 2017/8/30 0030.
 */
public class Administrator extends Person {
    public static int ENCODING = 3;
    public Administrator(){
        super();
    }
    public Administrator(String str){
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
            default:
                super.setField(fieldName, fieldValue);
                break;
        }
    }
}
