package day08.syn;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName UnSafeThread1
 * @Description 采用可重入锁来保证线程安全性
 * @Author huangbo1221
 * @Date 2021/8/22 11:29
 * @Version 1.0
 */

/**
 * 采用可重入锁的机制来保证线程安全性
 */
public class SafeThreadLock {

    public static void main(String[] args) {
        ThreadTest08Lock threadTest08Lock = new ThreadTest08Lock();

        new Thread(threadTest08Lock, "xiaoming").start();
        new Thread(threadTest08Lock, "xiaohong").start();
        new Thread(threadTest08Lock, "zhangshan").start();
    }
}

class ThreadTest08Lock implements Runnable {

    private static ReentrantLock lock = new ReentrantLock();

    // 票的总数
    private int tickets = 10;

    // 用来控制线程的退出，不要用线程自带的stop方法
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            buyTickets();
        }
        System.out.println("=======票卖完了=========");
    }

    private void buyTickets() {
        try {
            lock.lock();
            if (tickets <= 0) {
                flag = false;
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "买了第" + tickets-- + "张票！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
