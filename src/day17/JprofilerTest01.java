package day17;

import java.util.ArrayList;

/**
 * @ClassName JprofilerTest01
 * @Description 怎么利用jprofiler去抓包分析OOM
 * @Author huangbo1221
 * @Date 2021/9/13 8:10
 * @Version 1.0
 */


/**
 * -Xms 设置初始化分配的堆内存大小，默认情况下时内存的1/64
 * -Xmx 设置初始化分配的最大堆内存大小，默认情况下时内存的1/4
 * -XX:+PrintGCDetails 打印GC垃圾回收信息
 * -XX:+HeapDumpOnOutOfMemoryError 输出OOM dump.若想输出ClassNotFoundError，可将参数替换成
 * -XX:+HeapDumpOnClassNotFoundError
 *
 */
public class JprofilerTest01 {
    // 分配1M内存
    Byte[] demo = new Byte[1024 * 1024];

    public static void main(String[] args) {
        // 设置JVM参数 -Xms1m -Xmx2m -XX:+HeapDumpOnOutOfMemoryError
        // 打印堆内存溢出时的快照，用jprofiler分析
        ArrayList<JprofilerTest01> jprofilerTest01s = new ArrayList<>();
        int count = 0;

        try {
            while (true) {
                jprofilerTest01s.add(new JprofilerTest01());
                count++;
            }
//        } catch (Exception e) {
//            System.out.println("Exception happens!");
//            System.out.println(count);
//        }
        // 当捕获的异常是 Exception e时，输出如下：
        // 可以看出并没有执行catch里的内容
        /**
         * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
         * 	at day17.JprofilerTest01.<init>(JprofilerTest01.java:14)
         * 	at day17.JprofilerTest01.main(JprofilerTest01.java:23)
         */
        } catch (OutOfMemoryError e) {
            System.out.println("Exception happens!");
            System.out.println(count);
        }
        // 当捕获的异常是 OutOfMemoryError e时，输出如下：
        // 可以看出正确执行了catch里的内容
        // 分析：这里的逻辑是运行时的错误，OutOfMemoryError，Exception和Error都是Throwable的子类，
        // 捕获的东西应该是不一样的，否则无法捕获！
        /**
         * java.lang.OutOfMemoryError: Java heap space
         * Dumping heap to java_pid15248.hprof ...
         * Heap dump file created [1444070 bytes in 0.004 secs]
         * Exception happens!
         * 0
         */
    }
}
