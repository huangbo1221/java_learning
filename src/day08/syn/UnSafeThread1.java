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
 * xiaohong买了第10张票！
 * xiaoming买了第10张票！
 * zhangshan买了第9张票！
 * zhangshan买了第8张票！
 * xiaohong买了第7张票！
 * xiaoming买了第8张票！
 * xiaoming买了第6张票！
 * zhangshan买了第5张票！
 * xiaohong买了第4张票！
 * xiaoming买了第3张票！
 * zhangshan买了第3张票！
 * xiaohong买了第2张票！
 * zhangshan买了第1张票！
 * xiaoming买了第-1张票！
 * =======票卖完了=========
 * xiaohong买了第0张票！
 * =======票卖完了=========
 * =======票卖完了=========
 *
 * 1、为啥小明和小红都买到了第10张票呢？
 * 答：多线程之间是共享内存的，都内看到tickets变量，都以为自己买到的是第10张票。详细原因待分析，这里
 * 解释的比价浅。
 * 2、为啥实际的输出会有负数呢？
 * 每个线程都有自己的工作空间，最后只剩一张票时，都看到只有一张了。复制到自己的工作空间的是1
 */
public class UnSafeThread1 {

    public static void main(String[] args) {
        ThreadTest08 threadTest08 = new ThreadTest08();

        new Thread(threadTest08, "xiaoming").start();
        new Thread(threadTest08, "xiaohong").start();
        new Thread(threadTest08, "zhangshan").start();
    }
}

class ThreadTest08 implements Runnable {

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
