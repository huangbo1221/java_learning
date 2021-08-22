package day08;

/**
 * @ClassName ThreadPriorityTest
 * @Description 测试线程设置优先级的功能
 * @Author huangbo1221
 * @Date 2021/8/22 10:28
 * @Version 1.0
 */

/**
 * 从下面的运行结果来看，本来优先级更高的应该是优先执行，但实际结果仍是不可预测
 *
 */
public class ThreadPriorityTest {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new ThreadPriority());
        Thread thread2 = new Thread(new ThreadPriority());
        Thread thread3 = new Thread(new ThreadPriority());
        Thread thread4 = new Thread(new ThreadPriority());
        Thread thread5 = new Thread(new ThreadPriority());

        System.out.println(Thread.currentThread().getName() + " is running-->" + Thread.currentThread().getPriority());

        // test1
//        thread1.setPriority(8);
//        thread1.start();
//
//        thread2.setPriority(9);
//        thread2.start();
//
//        thread3.setPriority(2);
//        thread3.start();
//
//        thread4.setPriority(Thread.MAX_PRIORITY);
//        thread4.start();
//
//        thread5.setPriority(Thread.MIN_PRIORITY);
//        thread5.start();

        // test2
        thread1.setPriority(8);

        thread2.setPriority(9);

        thread3.setPriority(2);

        thread4.setPriority(Thread.MAX_PRIORITY);

        thread5.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();


    }
}


class ThreadPriority implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "  is running-->" + Thread.currentThread().getPriority());
    }
}
