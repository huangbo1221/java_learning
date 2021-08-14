package day02.internalclass;

/**
 * @ClassName Outer
 * @Description 测试内部类
 * @Author huangbo1221
 * @Date 2021/8/14 18:15
 * @Version 1.0
 */
public class Outer {

    private int id = 10;

    public void run() {
        System.out.println("这是外部类在运行！");
    }

    public void method() {
        // 局部内部类
        class InnerMethod {
            public void run1() {
                System.out.println("局部内部类在运行");
            }
        }
        new InnerMethod().run1();
    }

    // 成员内部类
    public class Inner {

        // 可以访问外部类的私有属性
        public void getID() {
            System.out.println("这是内部类在运行， id: " + id);
        }
    }

    public static class StaticInner {
        // 静态内部类不能访问外部类的非静态属性，因为静态类在外部类属性加载之前
        public static void run() {
            System.out.println("这是静态内部类在运行");
        }
    }
}
