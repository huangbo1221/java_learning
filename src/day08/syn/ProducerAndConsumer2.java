package day08.syn;

/**
 * @ClassName ProducerAndConsumer2
 * @Description TODO
 * @Author huangbo1221
 * @Date 2021/8/22 18:55
 * @Version 1.0
 */

/**
 * 并发协作模型“生产者/消费者模式”-->信号灯法
 */
// 演员、观众、节目、标志位
// 注意：这里的例子场景是：演员演出节目后，观众才能在电视上看
public class ProducerAndConsumer2 {

    public static void main(String[] args) {
        Tv tv = new Tv();

        new Thread(new Player(tv)).start();
        new Thread(new Watcher(tv)).start();
    }
}

class Player extends Thread {
    private Tv tv;

    public Player(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                try {
                    tv.play("倚天屠龙记");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    tv.play("笑傲江湖");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Watcher extends Thread {
    private Tv tv;

    public Watcher(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                tv.watch();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Tv {

    // 节目
    private String voice;

    // 标志位
    // 可以设定为：true则演员表演节目，false则观众观看节目
    private boolean flag = true;


    // 演员表演节目
    public synchronized void play(String voice) throws InterruptedException {
        if (!flag) {
            this.wait();
        }
        System.out.println("演员表演了" + voice + "节目");
        this.voice = voice;
        this.flag = !flag;
        this.notifyAll();
    }

    // 观众观看节目
    public synchronized void watch() throws InterruptedException {
        if (flag) {
            this.wait();
        }
        System.out.println("观众观看了" + voice + "节目");
        this.flag = !flag;
        this.notifyAll();
    }

}


