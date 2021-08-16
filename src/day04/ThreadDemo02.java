package day04;

/**
 * @ClassName ThreadDemo02
 * @Description 第二种创建线程的方式。相较于直接继承Thread的方式，推荐使用实现Runnable接口的方式
 * 因为这种发方式是实现接口，可以实现多个接口，同时还保留继承的能力
 * @Author huangbo1221
 * @Date 2021/8/16 21:37
 * @Version 1.0
 */
public class ThreadDemo02 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("多线程正在打印: " + i);
        }
    }

    public static void main(String[] args) {
        ThreadDemo02 threadDemo02 = new ThreadDemo02();
        new Thread(threadDemo02).start();

        for (int i = 0; i < 200; i++) {
            System.out.println("主线程正在打印: " + i);
        }
    }
}
