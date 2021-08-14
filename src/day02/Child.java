package day02;

/**
 * @ClassName Child
 * @Description 主要是为了结合father类，说明super的用法
 * @Author huangbo1221
 * @Date 2021/8/14 16:01
 * @Version 1.0
 */
public class Child extends Father{

    private String name = "child";

    public Child() {
//        System.out.println();
        super("this.name", 5);
        System.out.println("create a child!");
    }


    public void say() {
        System.out.println("i'm your child!");
    }

    public void test(String name) {
        System.out.println(name);
        System.out.println(this.name);
        System.out.println(super.name);
    }
}
