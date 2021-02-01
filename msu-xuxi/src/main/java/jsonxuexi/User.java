package jsonxuexi;

import com.alibaba.fastjson.JSONObject;

public class User {
    private String name;
    private int num;
    private String sex;
    private int age;





    public User() {
        // TODO Auto-generated constructor stub
        return ;
    }

    public User(String name, String sex,int age ) {
        super();
        this.name = name;
        this.age = age;
        this.sex = sex;


    }

    public String toString() {
        return "user [name=" + name + ", sex=" + sex + ", age="+ age + "]";
    }






    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
