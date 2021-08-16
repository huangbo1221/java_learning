package day04;

/**
 * @ClassName ThreadDemo3
 * @Description 多线程不控制并发时的问题。多个线程操作同一个资源的情况下，会出现并发问题
 * @Author huangbo1221
 * @Date 2021/8/16 22:05
 * @Version 1.0
 */
public class ThreadDemo3 implements Runnable{

    private int tickets = 10;

    @Override
    public void run() {

        while (true) {

            if (tickets <= 0) {
                break;
            }
            // 模拟买票的时延
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "买到了第"+ tickets--+ "张票");
        }
    }

    public static void main(String[] args) {

        ThreadDemo3 threadDemo3 = new ThreadDemo3();

        new Thread(threadDemo3, "小明").start();
        new Thread(threadDemo3, "小红").start();
        new Thread(threadDemo3, "黄牛").start();

    }
}
