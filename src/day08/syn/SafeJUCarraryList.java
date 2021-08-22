package day08.syn;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName SafeJUCarraryList
 * @Description 测试下java.util.concurrent包下的工具，内部有锁
 * @Author huangbo1221
 * @Date 2021/8/22 16:08
 * @Version 1.0
 */
public class SafeJUCarraryList {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList();

        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                copyOnWriteArrayList.add(Thread.currentThread().getName());
            }).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(copyOnWriteArrayList.size());
    }
}
