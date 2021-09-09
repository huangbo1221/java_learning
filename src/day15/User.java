package day15;

/**
 * @ClassName day15.User
 * @Description 测试类
 * @Author huangbo1221
 * @Date 2021/9/9 7:45
 * @Version 1.0
 */
public class User {
    public String name;

    private int id;

    private int age;

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "day15.User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
