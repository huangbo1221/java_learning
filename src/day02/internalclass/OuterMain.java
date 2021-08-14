package day02.internalclass;

/**
 * @ClassName OuterMain
 * @Description TODO
 * @Author huangbo1221
 * @Date 2021/8/14 18:18
 * @Version 1.0
 */
public class OuterMain {

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.run();
        outer.method();

        // 注意这个内部类的定义！！
        Outer.Inner inner = outer.new Inner();
        inner.getID();

        Outer.StaticInner.run();



        UserService userService = new UserService() {
            @Override
            public void hello() {
                System.out.println("这个是匿名内部类");
            }
        };
        userService.hello();
    }

}

// 一个java文件可以定义多个平级的类，但是只能有一个类是public的，比如这里的TestA就不能为public
class TestA {
    public static void main(String[] args) {
        System.out.println("测试而已");
    }
}

interface UserService {
    void hello();
}