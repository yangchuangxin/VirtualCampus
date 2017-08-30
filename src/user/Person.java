package user;

/**
 * Created by John on 2017/8/30 0030.
 */
class Person {
    private String id;
    private String name;
    private String age;
    private String sex;
    private String password;
    private static long serialNumber = 0; //流水号

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /*
    public Person setId(long id){
        this.id = "" + id;
        return this;
    }
    */

    public Person setId(String id) {
        this.id = id;
        return this;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    /*
    public Person setAge(int age) {
        this.age = "" + age;
        return this;
    }
    */

    public Person setAge(String age) {
        this.age = age;
        return this;
    }

    public Person setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public Person setPassword(String password){
        this.password = password;
        return this;
    }

    public String getId() {
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

    public String getPassword(){
        return password;
    }

    public static String creatId(){



        return null;
    }
}
