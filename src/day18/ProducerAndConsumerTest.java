package day18;

/**
 * @ClassName ProducerAndConsumerTest
 * @Description 什么是虚假唤醒？
 * @Author huangbo1221
 * @Date 2021/9/23 7:59
 * @Version 1.0
 */
public class ProducerAndConsumerTest {
    public static void main(String[] args) {
        Shop shop = new Shop();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    shop.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    shop.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        // 如果只有A、B两个线程，输出如下：可见，是线程安全的。但是如果有多个线程呢？？
        /**
         * A---->1
         * B---->0
         * A---->1
         * B---->0
         * A---->1
         * B---->0
         * A---->1
         * B---->0
         * A---->1
         * B---->0
         * A---->1
         * B---->0
         * A---->1
         * B---->0
         * A---->1
         * B---->0
         * A---->1
         * B---->0
         * A---->1
         * B---->0
         */

        System.out.println("================================");
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    shop.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    shop.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();

        // 输出如下：截取了一部分结果。出现了data值为0？？？意料之外的情况！
        /**
         * A---->1
         * B---->0
         * C---->-1
         * C---->-2
         * C---->-3
         * B---->-4
         * B---->-5
         * D---->-6
         */
        /**
         * 分析：同步块里使用的是if来做判断，而if在同步块中，只会判断一次。以上面的例子举例，当B线程消费完，
         * data值变为0，此时执行了notifyAll操作唤醒了所有线程，当C执行到if语句时，不会再次判断if语句，转而
         * 直接执行data--。导致结果变为负数。   即虚假唤醒！！！！
         *
         * 也就是说，使用synchronized同步，当生产者或者消费者存在多个，且用了if判断时，会出现虚假唤醒问题！
         * 详细可见java.lang.Object的官方文档，要求使用while来解决该问题：
         *
         * 线程也可以唤醒，而不会被通知，中断或超时，即所谓的虚假唤醒 。 虽然这在实践中很少会发生，但应用程序必
         * 须通过测试应该使线程被唤醒的条件来防范，并且如果条件不满足则继续等待。 换句话说，等待应该总是出现在
         * 循环中，就像这样：
         *
         *   synchronized (obj) {
         *          while (<condition does not hold>)
         *              obj.wait(timeout);
         *          ... // Perform action appropriate to condition
         *      }
         */
        System.out.println("==============================");
        // 改成while来控制循环等待后，输出结果如下：
        /**
         * A---->1
         * ================================
         * B---->0
         * A---->1
         * B---->0
         * A---->1
         * B---->0
         * A---->1
         * B---->0
         * A---->1
         * B---->0
         * A---->1
         * B---->0
         * A---->1
         * B---->0
         * A---->1
         * B---->0
         * A---->1
         * B---->0
         * A---->1
         * C---->0
         */
    }
}


class Shop {
    // 定义某种商品的数量，只要不为0，就得先卖完。卖完了再生产，生产了直到卖完再生产。
    // 即最大数量只能为1，最小只能为0.
    private int data = 0;

    public synchronized void increase() throws InterruptedException {
        while (data != 0) {
            // 不为0，就要等卖完
            this.wait();
        }
        data++;
        System.out.println(Thread.currentThread().getName()+ "---->" + data);
        // 已经不为0了，告诉消费者来消费
        this.notifyAll();
    }

    public synchronized void decrease() throws InterruptedException {
        while (data == 0) {
            // 商品数量为0，等生产后再消费
            this.wait();
        }
        data--;
        System.out.println(Thread.currentThread().getName()+ "---->" + data);
        // 变为0了，通知生产者生产
        this.notifyAll();
    }
}
