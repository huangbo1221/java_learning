package day16;

/**
 * @ClassName GcTest01
 * @Description 了解下堆内存的分配
 * @Author huangbo1221
 * @Date 2021/9/10 21:16
 * @Version 1.0
 */
public class GcTest01 {
    public static void main(String[] args) {

        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();

        System.out.println("maxMemory: " + maxMemory/(double)1024/1024 );
        System.out.println("totalMemory: " + totalMemory/(double)1024/1024 );
        // 上面的输出如下：
        /**
         * maxMemory: 3572.0
         * totalMemory: 241.5
         * 可知：在没有人为设置情况下，给堆分配的最大可用内存为系统内存的1/4，总内存为系统
         * 内存的1/64
         */
        System.out.println("==========================================");
        // 调整VM options参数后 -Xms1024m -Xmx1024m -XX:+PrintGCDetails
        /**
         * maxMemory: 981.5
         * totalMemory: 981.5
         * Heap
         *  PSYoungGen      total 305664K, used 15729K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
         *   eden space 262144K, 6% used [0x00000000eab00000,0x00000000eba5c420,0x00000000fab00000)
         *   from space 43520K, 0% used [0x00000000fd580000,0x00000000fd580000,0x0000000100000000)
         *   to   space 43520K, 0% used [0x00000000fab00000,0x00000000fab00000,0x00000000fd580000)
         *  ParOldGen       total 699392K, used 0K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
         *   object space 699392K, 0% used [0x00000000c0000000,0x00000000c0000000,0x00000000eab00000)
         *  Metaspace       used 3237K, capacity 4496K, committed 4864K, reserved 1056768K
         *   class space    used 354K, capacity 388K, committed 512K, reserved 1048576K
         */
        // 根据打印的详细GC参数可知，在分配给堆内存时，新生代和老年代的比值一般为1:2
        // 新生代 = eden区 + from区 + to区，其中from区和to区在不停地交换位置。当minor gc发生一次时，部分对象会被移到from区
        // 被标记多次的对象会被移到to区，被标记超过15次的对象会被移到老年代。老年代空间满了之后，会触发full gc！

    }
}
