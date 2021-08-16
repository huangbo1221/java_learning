package day04;

/**
 * @ClassName RabbitAndTortoiseRace
 * @Description 多线程模拟龟兔赛跑
 * @Author huangbo1221
 * @Date 2021/8/16 22:37
 * @Version 1.0
 */
public class RabbitAndTortoiseRace implements Runnable{

    private static String winner;

    @Override
    public void run() {
        for (int i = 0; 1 <= 100; i++) {

            if (Thread.currentThread().getName().equals("兔子") && i % 50 == 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() +
                "正在跑第" + i + "步");
            if (running(i)) {
                break;
            }
        }
    }

    private boolean running(int steps) {
        // 如果winner不为null，则表示已经有胜利者了
        if (winner != null) {
            return true;
        }
        if (steps >= 100) {
            winner = Thread.currentThread().getName();
            return true;
        }
        // 否则没有胜利者
        return false;
    }

    public static void main(String[] args) {
        RabbitAndTortoiseRace rabbitAndTortoiseRace = new RabbitAndTortoiseRace();

        new Thread(rabbitAndTortoiseRace, "兔子").start();
        new Thread(rabbitAndTortoiseRace, "乌龟").start();
    }
}
