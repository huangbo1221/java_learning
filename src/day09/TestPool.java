package day09;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName TestPool
 * @Description 测试下线程池的使用，简单认识下
 * @Author huangbo1221
 * @Date 2021/8/23 22:39
 * @Version 1.0
 */
public class TestPool {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        es.execute(new MyThread());
        es.execute(new MyThread());
        es.execute(new MyThread());
        es.execute(new MyThread());
        es.shutdown();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
