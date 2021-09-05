package day12.reflection;

/**
 * @ClassName ReflectionTest01
 * @Description 初识反射获取Class对象
 * @Author huangbo1221
 * @Date 2021/9/5 9:37
 * @Version 1.0
 */
public class ReflectionTest01 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("day12.reflection.User");

        Class c2 = c1.getClass();
        Class c3 = c1.getClass();
        Class c4 = c1.getClass();
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());
        // 上面打印的三个hashcode是一样的。因为每个类在内存中只有一个class对象！
        // 1、一个加载的类在JVM中只会有一个Class实例
        // 2、一个Class对象对应的是一个加载到JVM中的一个.class文件
        // 3、每个类的实例都会记得自己是由哪个Class实例所生成的
    }
}

class User {
    private String name;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
