package day08.syn;

/**
 * @ClassName UnSafeThread1
 * @Description 线程不安全
 * @Author huangbo1221
 * @Date 2021/8/22 11:29
 * @Version 1.0
 */

/**
 * 最后的输出截取了一部分如下：
 * xiaoming买了第10张票！
 * xiaoming买了第9张票！
 * xiaoming买了第8张票！
 * xiaoming买了第7张票！
 * xiaoming买了第6张票！
 * xiaoming买了第5张票！
 * zhangshan买了第4张票！
 * zhangshan买了第3张票！
 * zhangshan买了第2张票！
 * zhangshan买了第1张票！
 * =======票卖完了=========
 * =======票卖完了=========
 * =======票卖完了=========
 *
 * buyTickets方法变成了同步方法，用synchronized修饰的方法。
 * 每个对象对应一把锁，每个synchronized方法都必须获得调用该方法的对象的网锁才能执行，
 * 否则线程会阻塞。
 *
 * 这里指的对象就是threadTestSafe08对象
 */
public class SafeThread1 {

    public static void main(String[] args) {
        ThreadTestSafe08 threadTestSafe08 = new ThreadTestSafe08();

        new Thread(threadTestSafe08, "xiaoming").start();
        new Thread(threadTestSafe08, "xiaohong").start();
        new Thread(threadTestSafe08, "zhangshan").start();
    }
}

class ThreadTestSafe08 implements Runnable {

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

    private synchronized void buyTickets() {
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
    }
}
