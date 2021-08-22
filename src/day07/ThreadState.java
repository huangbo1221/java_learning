package day07;

/**
 * @ClassName ThreadState
 * @Description 观察线程的几种状态
 * @Author huangbo1221
 * @Date 2021/8/21 12:27
 * @Version 1.0
 */
public class ThreadState {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("start=====================");
            for (int i = 0; i < 2; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("end=====================");
        });

        Thread.State state = thread.getState();
        System.out.println(state);// NEW状态

        thread.start();
        state = thread.getState();
        System.out.println(state);

        while (state != Thread.State.TERMINATED) {
            state = thread.getState();
            System.out.println(state);
        }
    }

}
