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
 * 9998
 *
 * 原因分析：因为list不是线程安全的，当多线程和同时操作list的add时，可能会把不同元素添加到相同所引处
 */
public class UnSafeList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
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
