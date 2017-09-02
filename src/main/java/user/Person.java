package user;

import java.lang.reflect.Field;

/**
 * Created by John on 2017/8/30 0030.
 */
public  class Person {
    private long id; //流水号
    private String name;
    private String sex;
    private String age;
    private String cardNumber; //类型编码 + 年份后两位 + id
    private String password;
    private String telephone;
    private String mailbox;
    //protected static long serialNumber = 0; //流水号

    Person() {
        name = "";
        sex = "";
        age = "";
        cardNumber = "";
        password = "";
        telephone = "";
        mailbox = "";
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

        Class cls = this.getClass().getSuperclass();
        Field[] fields = cls.getDeclaredFields();

        addFieldsToStringBuilder(fields, ret);

        return ret.toString();
    }

    /**
     * @param fields        fields
     * @param stringBuilder stringBuilder
     * @return 符合要求的字段数量
     */
    void addFieldsToStringBuilder(Field[] fields, StringBuilder stringBuilder) {
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                stringBuilder.append(field.getName()).append(":").
                        append(field.get(this)).append(";");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
