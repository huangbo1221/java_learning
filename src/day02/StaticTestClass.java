package day02;

/**
 * @ClassName StaticTestClass
 * @Description 测试static的用法
 * @Author huangbo1221
 * @Date 2021/8/14 17:10
 * @Version 1.0
 */
public class StaticTestClass {

    // 比构造函数先执行。一般用来赋初始值
    {
        System.out.println("匿名代码块");
    }

    // 随类加载，最先执行
    static {
        System.out.println("静态代码块");
    }

    public StaticTestClass() {
        System.out.println("construct method!");
    }

    public static void main(String[] args) {
        StaticTestClass staticTestClass = new StaticTestClass();
        // 执行上面这一句，输出结果为：
        // 静态代码块
        // 匿名代码块
        // construct method!

        System.out.println("===================");
        StaticTestClass sta = new StaticTestClass();
        // 加上上面的输出结果，总的输出结果如下：
        // 静态代码块
        // 匿名代码块
        // construct method!
        // ===================
        // 匿名代码块
        // construct method!
        // 可以看出来，static方法只加载一次
    }
}
