package day02;

/**
 * @ClassName AbstractMain
 * @Description TODO
 * @Author huangbo1221
 * @Date 2021/8/14 17:38
 * @Version 1.0
 */
public class AbstractMain extends AbstractTestClass{
    @Override
    public void run() {
        System.out.println("AbstractMain is running");
    }

//    @Override
    public void say() {
        System.out.println("AbstractMain say hello!");
    }

    public static void main(String[] args) {
        AbstractTestClass abstractMain = new AbstractMain();
        abstractMain.run();
        abstractMain.say();
        // 上面的输出为：可见，@Override不是一定需要，但是这个注解可以帮助编译器检查
        /**
         * 1、可以当注释用,方便阅读；
         *
         * 2、编译器可以给你验证@Override下面的方法名是否是你父类中所有的，如果没有则报错。
         * 例如，你如果没写@Override，而你下面的方法名又写错了，这时你的编译器是可以编译通
         * 过的，因为编译器以为这个方法是你的子类中自己增加的方法。
         */
        /**
         * AbstractMain is running
         * AbstractMain say hello!
         */
    }
}
