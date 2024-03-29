package standard.ch15.serialization;

import java.io.Serializable;

public class UserInfo implements Serializable {
    String name;
    String password;
    int age;

    public UserInfo() {

    }

    public UserInfo(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
