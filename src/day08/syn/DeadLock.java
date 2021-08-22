package day08.syn;

import java.util.TreeMap;

/**
 * @ClassName DeadLock
 * @Description 体验下什么叫死锁
 * @Author huangbo1221
 * @Date 2021/8/22 16:53
 * @Version 1.0
 */

/**
 * makeup test1例子中，synchronized嵌套存在，在第一个if里，小红拿到了口红的锁，但是没有释放
 * 还想拿镜子的锁。同时，小馨拿到了镜子的锁，没有释放的条件下还想拿口红的锁。两者同时等待，进入了死锁！
 * 注意：如果在该例子中，将mirror定义成private Mirror mirror = new Mirror(); 将lipstick定义成
 * private Lipstick lipstick = new Lipstick();
 * 这种情况也不会造成死锁！！！
 * 分析：当你new一个MakeUp对象时，mirror和lipstick都是重新new出来的，不能保证唯一性，下面的makeup方法中，
 * 小红和小馨针对mirror拿的锁，都是不同对象的锁！！
 * 因此必须定义成static Mirror mirror = new Mirror(); 和 static Lipstick lipstick = new Lipstick();
 * 保证锁的唯一性
 *
 *
 *
 * makeup test2例子中,synchronized没有嵌套，在第一个if里，小红拿到了口红的锁，执行完成后释放口红的锁，去等待镜子资源
 * 同时，小馨拿到了镜子的锁并且释放后，再去等口红的资源。
 * 两者不会等待太久，因此最终不会造成死锁。
 */
public class DeadLock {

    public static void main(String[] args) {
        new Thread(new MakeUp("小红", 0)).start();
        new Thread(new MakeUp("小馨", 1)).start();
    }
}


class Lipstick {

}

class Mirror {

}

class MakeUp extends Thread {
    static Mirror mirror = new Mirror();

    static Lipstick lipstick = new Lipstick();

    private String name;

    private int choice;

    public MakeUp(String name, int choice) {
        super(name);
        this.name = name;
        this.choice = choice;
    }

    @Override
    public void run() {
        try {
            makeUp();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // makeup test1
    public void makeUp() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipstick) {
                System.out.println(this.name + "拿到了口红");
                Thread.sleep(1000);
                synchronized (mirror) {
                    System.out.println(this.name + "拿到了镜子！");
                }
            }
        } else {
            synchronized (mirror) {
                System.out.println(this.name + "拿到了镜子！");
                Thread.sleep(2000);
                synchronized (lipstick) {
                    System.out.println(this.name + "拿到了口红！");
                }
            }
        }
    }

    // makeup test2
//    public void makeUp() throws InterruptedException {
//        if (choice == 0) {
//            synchronized (lipstick) {
//                System.out.println(this.name + "拿到了口红");
//                Thread.sleep(1000);
//            }
//            synchronized (mirror) {
//                System.out.println(this.name + "拿到了镜子！");
//            }
//        } else {
//            synchronized (mirror) {
//                System.out.println(this.name + "拿到了镜子！");
//                Thread.sleep(2000);
//            }
//            synchronized (lipstick) {
//                System.out.println(this.name + "拿到了口红！");
//            }
//        }
//    }
}