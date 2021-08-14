package day02;

/**
 * @ClassName Father
 * @Description 为了了解super的用法
 * @Author huangbo1221
 * @Date 2021/8/14 16:00
 * @Version 1.0
 */
public class Father {

    public String name = "father";

    public Father() {
        System.out.println("create a father!");
    }

    public Father(String name, int age) {
        System.out.println("person name: " + name + "   age: " + age);
    }

    public void say() {
        System.out.println("i'm your father!");
    }

}
