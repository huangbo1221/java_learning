package day08;

/**
 * @ClassName ThreadDeamonTest
 * @Description 测试守护线程和用户线程
 * @Author huangbo1221
 * @Date 2021/8/22 10:59
 * @Version 1.0
 */

/**
 * 1、线程分为用户线程和守护线程
 * 2、虚拟机必须确保用户线程执行完毕
 * 3、虚拟机不必等待守护线程执行完毕。比如下面的守护线程，当用户线程执行完毕后，虚拟机再停止后，守护
 *    线程也就执行完毕了
 * 4、守护线程的例子：后台记录操作日志、监控内存、垃圾回收等
 */
public class ThreadDeamonTest {

    public static void main(String[] args) {

        Thread threadDeamon = new Thread(() -> {
            while (true) {
                System.out.println("我是守护线程，一直在守护你！");
            }
        });
        threadDeamon.setDaemon(true); // 设置为守护线程
        threadDeamon.start();

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 3600; i++) {
                System.out.println("我是用户线程。正在运行！");
            }
            System.out.println("=============用户线程运行完毕===========");
        });
        thread.start();

    }

}
