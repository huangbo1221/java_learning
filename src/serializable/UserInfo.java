package serializable;

import java.io.Serializable;

/**
 * @ClassName UserInfo
 * @Description TODO
 * @Author huangbo1221
 * @Date 2021/11/8 21:21
 * @Version 1.0
 */

public class UserInfo implements Serializable {

    private static final long serialVersionUID = -403156719994603529L;

    private String name;

    private Integer age;

    private String id;

    private transient String passwd;

    public UserInfo(String name, Integer age, String id, String passwd) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPasswd() {
        return passwd;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", id='" + id + '\'' +
            ", passwd='" + passwd + '\'' +
            '}';
    }
}
