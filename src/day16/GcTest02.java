package day16;

import java.util.Random;

/**
 * @ClassName GcTest02
 * @Description 测试内存溢出OOM
 * @Author huangbo1221
 * @Date 2021/9/10 21:42
 * @Version 1.0
 */
public class GcTest02 {
    public static void main(String[] args) {
        // 设置JVM参数   -Xms8m -Xmx8m -XX:+PrintGCDetails
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();

        System.out.println("maxMemory: " + maxMemory/(double)1024 );
        System.out.println("totalMemory: " + totalMemory/(double)1024 );

        System.out.println("=======================================");
        // 怎么去判断代码java代码可能会造成内存OOM？
        /**
         * 可以先设置VM OPTIONS参数，设置初始的JVM堆内存，执行代码，当内存发生OOM时，
         * 调大JVM参数，若还发生OOM，则是java代码存在问题
         */

        String str = "11111111111111111111";

        while (true) {
            str += str + new Random().nextInt(111111) + new Random().nextInt(2222222);
        }
        // 输出如下：
        /**
         * [GC (Allocation Failure) [PSYoungGen: 1536K->504K(2048K)] 1536K->672K(7680K), 0.0008828 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         * maxMemory: 7.5
         * totalMemory: 7.5
         * =======================================
         * [GC (Allocation Failure) [PSYoungGen: 1992K->502K(2048K)] 2160K->956K(7680K), 0.0006090 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         * [GC (Allocation Failure) [PSYoungGen: 1791K->424K(2048K)] 2246K->1635K(7680K), 0.0005518 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         * [GC (Allocation Failure) [PSYoungGen: 1462K->496K(2048K)] 3683K->3221K(7680K), 0.0004734 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         * [GC (Allocation Failure) [PSYoungGen: 1030K->440K(2048K)] 4765K->4174K(7680K), 0.0004321 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         * [GC (Allocation Failure) [PSYoungGen: 440K->408K(2048K)] 4174K->4142K(7680K), 0.0003851 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         * [Full GC (Allocation Failure) [PSYoungGen: 408K->0K(2048K)] [ParOldGen: 3734K->2174K(5632K)] 4142K->2174K(7680K), [Metaspace: 3330K->3330K(1056768K)], 0.0043809 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         * [Full GC (Ergonomics) [PSYoungGen: 1069K->0K(2048K)] [ParOldGen: 5203K->2678K(5632K)] 6272K->2678K(7680K), [Metaspace: 3330K->3330K(1056768K)], 0.0040510 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
         * [GC (Allocation Failure) [PSYoungGen: 30K->0K(2048K)] 4727K->4697K(7680K), 0.0002573 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         * [GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] 4697K->4697K(7680K), 0.0001920 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         * [Full GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] [ParOldGen: 4697K->3688K(5632K)] 4697K->3688K(7680K), [Metaspace: 3330K->3330K(1056768K)], 0.0015787 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         * [GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] 3688K->3688K(7680K), 0.0002546 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         * [Full GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] [ParOldGen: 3688K->3668K(5632K)] 3688K->3668K(7680K), [Metaspace: 3330K->3330K(1056768K)], 0.0041044 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         * Heap
         *  PSYoungGen      total 2048K, used 61K [0x00000000ffd80000, 0x0000000100000000, 0x0000000100000000)
         *   eden space 1536K, 3% used [0x00000000ffd80000,0x00000000ffd8f440,0x00000000fff00000)
         *   from space 512K, 0% used [0x00000000fff00000,0x00000000fff00000,0x00000000fff80000)
         *   to   space 512K, 0% used [0x00000000fff80000,0x00000000fff80000,0x0000000100000000)
         *  ParOldGen       total 5632K, used 3668K [0x00000000ff800000, 0x00000000ffd80000, 0x00000000ffd80000)
         *   object space 5632K, 65% used [0x00000000ff800000,0x00000000ffb951d0,0x00000000ffd80000)
         *  Metaspace       used 3361K, capacity 4496K, committed 4864K, reserved 1056768K
         *   class space    used 364K, capacity 388K, committed 512K, reserved 1048576K
         * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
         * 	at java.util.Arrays.copyOf(Arrays.java:3332)
         * 	at java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:124)
         * 	at java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:674)
         * 	at java.lang.StringBuilder.append(StringBuilder.java:208)
         * 	at day16.GcTest02.main(GcTest02.java:31)
         */

        // 由上可以知道一开始执行时，发生了minor gc，后来不断full gc，直到无法GC时，发生了OOM

        // 还有一点要特别注意：
        /**
         * maxMemory: 7680.0
         * totalMemory: 7680.0
         */
        // 我们 PSYoungGen（2048K） + ParOldGen（5632K） = 7680K，那么元空间Metaspace的3362K从哪里来的？？
        /**
         * 两种说法：
         * 1、元空间其实是一种概念，其实际也是堆内存的一部分，只是为了在概念上与堆内存进行区分。也如经常所说的：逻辑上存在，物理上不存在
         * 2、元空间不在JVM的内存里，而是在系统的直接内存里？
         *
         * 两种说法需要去查阅，才能知道哪个正确
         */
    }
}
