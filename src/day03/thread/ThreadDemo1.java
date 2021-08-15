package day03.thread;

/**
 * @ClassName ThreadDemo1
 * @Description 实现线程方式1：继承Thread
 * @Author huangbo1221
 * @Date 2021/8/15 21:31
 * @Version 1.0
 */
// 线程开启不一定立即执行，由CPU的调度来决定
public class ThreadDemo1 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("多线程打印-----" + i);
        }
    }

    public static void main(String[] args) {

        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        // 如果这里是执行的ThreadDemo1的run方法，则就是普通的类，会执行完run方法后再执行主线程
//        threadDemo1.run();
        // 不同于上面的threadDemo1.run();   这句会开启多线程执行，run方法里的打印和main里的打印会交替执行
        threadDemo1.start();

        for (int i = 0; i < 200; i++) {
            System.out.println("主线程打印-----" + i);
        }
    }
}
