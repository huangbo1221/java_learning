package day08.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UnSafeList
 * @Description ArrayList是线程不安全的
 * @Author huangbo1221
 * @Date 2021/8/22 12:17
 * @Version 1.0
 */

/**
 * output：
 * 10000
 *
 * 原因分析：因为list不是线程安全的，利用synchronized的同步代码块功能，可以保证线程安全
 */
public class SafeList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                synchronized (list) {
                    list.add(Thread.currentThread().getName());

                }
            }).start();
        }
        // 确保所有线程都执行完毕
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
