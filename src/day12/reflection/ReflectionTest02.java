package day12.reflection;

/**
 * @ClassName ReflectionTest02
 * @Description 获取Class对象的几种方式
 * @Author huangbo1221
 * @Date 2021/9/5 11:15
 * @Version 1.0
 */
public class ReflectionTest02 {

    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是：" + person.getName());

        // 通过对象获得
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        // 通过forname获得
        Class c2 = Class.forName("day12.reflection.Student");
        System.out.println(c2.hashCode());

        // 通过类名.class获得
        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        // 基本内置类型的包装类型都有一个Type属性
        Class c4 = Integer.TYPE;
        System.out.println(c4.hashCode());

        // 获得父类类型
        Class superclass = c1.getSuperclass();
        System.out.println(superclass);
    }
}

class Person {
    public String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Student extends Person {
    public Student() {
        this.name = "学生";
    }
}

class Teacher extends Person {
    public Teacher() {
        this.name = "老师";
    }
}
