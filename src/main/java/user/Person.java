package user;

/**
 * Created by John on 2017/8/30 0030.
 */
public class Person {
    private long id = 0; //流水号
    private String name = "";
    private String sex = "";
    private String age = "";
    private String cardNumber = ""; //类型编码 + 年份后两位 + id
    private String password = "";
    private String telephone = "";
    private String mailbox = "";
    //protected static long serialNumber = 0; //流水号

    private static int CURRENT_USER = 0;
    private static final int STUDENT = 1;
    private static final int TEACHER = 2;
    private static final int ADMINISTRATOR = 3;

    Person() {
    }

    /**
     * 未完成
     *
     * @return
     */
    public String createCardNumber() {
        return "";
    }

    public Person setId(long id) {
        this.id = id;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    void setField(String fieldName, String fieldValue) {
        switch (fieldName) {
            case "id":
                setId(Long.parseLong(fieldValue));
                break;
            case "name":
                setName(fieldValue);
                break;
            case "sex":
                setSex(fieldValue);
                break;
            case "age":
                setAge(fieldValue);
                break;
            case "cardNumber":
                setCardNumber(fieldValue);
                break;
            case "password":
                setPassword(fieldValue);
                break;
            case "telephone":
                setTelephone(fieldValue);
                break;
            case "mailbox":
                setMailbox(fieldValue);
                break;

            default:
                break;
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getMailbox() {
        return mailbox;
    }


    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("id:").append(getId())
                .append(";name:").append(getName())
                .append(";sex:").append(getSex())
                .append(";age:").append(getAge())
                .append(";cardNumber:").append(getCardNumber())
                .append(";password:").append(getPassword())
                .append(";telephone:").append(getTelephone())
                .append(";mailbox:").append(getMailbox())
                .append(";");
        return ret.toString();
    }
}
