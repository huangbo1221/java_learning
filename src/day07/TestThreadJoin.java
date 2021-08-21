package day07;

/**
 * @ClassName TestThreadJoin
 * @Description 测试Thread类中join方法的作用
 * @Author huangbo1221
 * @Date 2021/8/21 11:56
 * @Version 1.0
 */
// join方法的作用：强制当前线程执行完毕之后，再执行其他线程
// 在下面的例子中：前期是主线程和线程一起执行，但是当主线程的
// i值达到200后，join方法会让分支线程执行完毕后，再执行主线程
// 实际就是阻塞了其他线程！
public class TestThreadJoin implements Runnable{

    public static void main(String[] args) {
        Thread thread = new Thread(new TestThreadJoin());
        thread.start();

        for (int i = 0; i < 500; i++) {
            if (i == 200) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("主线程正在运行" + i);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程正在运行" + i);
        }
    }
}
