package day08.syn;

/**
 * @ClassName ProducerAndConsumer
 * @Description 多线程间的生产者和消费者问题
 * @Author huangbo1221
 * @Date 2021/8/22 17:59
 * @Version 1.0
 */

/**
 * 并发协作模型“生产者/消费者模式” --> 管程法
 * 生产者：负责生产数据的模块（可能是方法、对象、进程或者线程）；
 * 消费者：负责处理数据的模块（可能是方法、对象、进程或者线程）；
 * 缓冲区：消费者不能直接使用生产者的数据，他们之间有个”缓冲区“
 *
 * 生产者将生产好的数据放入缓冲区，消费者从缓冲区拿出数据
 *
 *
 * 分析：得有生产者（不停生产物品）、消费者（不停地消费物品）、缓冲区（有一定的大小，当生产者
 * 生产的数量达到缓冲区大小时，一定要暂停生产，等待消费者消费；当缓冲区没有物品时，消费者要等
 * 生产者生产后再消费），物品
 */
public class ProducerAndConsumer {
    public static void main(String[] args) {
        Container container = new Container();

        new Thread(new Producer(container)).start();
        new Thread(new Consumer(container)).start();
    }
}

class Producer extends Thread {
    private Container container;
    public Producer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Chicken chicken = new Chicken(i + 1);
            try {
                container.push(chicken);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private Container container;

    public Consumer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                container.pop();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Chicken {
    // 鸡的编号
    private int id;

    public Chicken(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

class Container {
    private Chicken[] chickens = new Chicken[10];

    private int size;

    // 生产者要生产物品
    public synchronized void push(Chicken chicken) throws InterruptedException {
        if (size == chickens.length) {
            // 容器装满了，得等消费者去消费，才能继续生产
            System.out.println("消费者赶紧来消费呀");
            this.wait();
        }
        // 若容器没满，则持续生产，生产了之后表示有物品了，得通知消费者赶紧消费
        chickens[size++] = chicken;
        System.out.println("生产者生产了第" + chicken.getId() + "只鸡");
        // 通知消费者来消费
        this.notifyAll();
    }

    // 消费者要消费物品
    public synchronized void pop() throws InterruptedException {
        if (size == 0) {
            // 没有物品，得等生产者生产了之后，才能消费
            System.out.println("没鸡啦，生产者赶紧生产！");
            this.wait();
        }
        Chicken chicken = chickens[--size];
        System.out.println("消费者消费了第" + chicken.getId() + "只鸡");
        // 消费者消费了，告诉生产者可以生产
        this.notifyAll();
    }
}