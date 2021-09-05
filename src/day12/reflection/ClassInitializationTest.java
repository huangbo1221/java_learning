package day12.reflection;

/**
 * @ClassName ClassInitializationTest
 * @Description 了解下类什么时候可以被加载
 * @Author huangbo1221
 * @Date 2021/9/5 16:17
 * @Version 1.0
 */
public class ClassInitializationTest {
    static {
        System.out.println("main static");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        // 1、主动引用方式
//        Child child = new Child();
//        System.out.println(child.b);
        // 输出如下：
//        main static
//        father static
//        child static
//        father constructor
//        child constructor
//        3

        // 2、反射也会产生主动引用
//        Class<?> aClass = Class.forName("day12.reflection.Child");
        // 输出如下：
//        main static
//        father static
//        child static

        // 不会产生主动引用（子类访问了父类的静态变量，可以看到子类并没有被加载，只是加载了父类）
//        System.out.println(Child.fatherAge);
        // 输出如下：
//        main static
//        father static
//        1


        //子类和父类都被加载了，产生了引用
//        System.out.println(Child.b);
        // 输出如下：
//        main static
//        father static
//        child static
//        3

        Child[] childArr = new Child[5];
        // 输出如下：
//        main static
    }
}

class Father {
    static {
        System.out.println("father static");
    }

    public Father() {
        System.out.println("father constructor");
    }

    static int fatherAge = 1;
}

class Child extends Father {
    static {
        System.out.println("child static");
    }

    public Child() {
        System.out.println("child constructor");
    }

    public static final int AGE = 2;

    public static  int b = 3;
}