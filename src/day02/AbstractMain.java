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

    public static void main(String[] args) {
        AbstractMain abstractMain = new AbstractMain();
        abstractMain.run();
        abstractMain.say();
    }
}
