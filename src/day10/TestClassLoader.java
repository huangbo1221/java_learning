package day10;

/**
 * @ClassName TestClassLoader
 * @Description TODO
 * @Author huangbo1221
 * @Date 2021/8/24 22:45
 * @Version 1.0
 */

/**
 * 输出为：
 * 1956725890
 * 356573597
 * 1735600054
 * 1163157884
 * 1163157884
 * 1163157884
 * 414493378
 * 414493378
 * 414493378
 *
 * 解释：
 * 前面三个之所以不一样，是因为testClassLoader1和testClassLoader2、testClassLoader3
 * 是三个不同的实例化对象。
 * 而testClassLoader1.getClass()是返回最初的模板类，上面的三个类都是由一个模板类new出来的
 * 最后三个来自于同一个类加载器
 */
public class TestClassLoader {

    public static void main(String[] args) {

        TestClassLoader testClassLoader1 = new TestClassLoader();
        TestClassLoader testClassLoader2 = new TestClassLoader();
        TestClassLoader testClassLoader3 = new TestClassLoader();
        System.out.println(testClassLoader1.hashCode());
        System.out.println(testClassLoader2.hashCode());
        System.out.println(testClassLoader3.hashCode());

        Class<? extends TestClassLoader> aClass1 = testClassLoader1.getClass();
        Class<? extends TestClassLoader> aClass2 = testClassLoader1.getClass();
        Class<? extends TestClassLoader> aClass3 = testClassLoader1.getClass();
        System.out.println(aClass1.hashCode());
        System.out.println(aClass2.hashCode());
        System.out.println(aClass3.hashCode());

        ClassLoader classLoader1 = aClass1.getClassLoader();
        ClassLoader classLoader2 = aClass2.getClassLoader();
        ClassLoader classLoader3 = aClass3.getClassLoader();
        System.out.println(classLoader1.hashCode());
        System.out.println(classLoader2.hashCode());
        System.out.println(classLoader3.hashCode());




        new Thread(() -> {

        }, "test").start();
        // 在Thread类可以看到，调用start后，最终会调用一个start0方法，就截止了
        // private native void start0();
        /**
         * 说明：
         * native:凡是带了native关键字的，表示java能达到的作用范围就已经截止了。如Thread类的start0方法，
         * 线程级别的功能就涉及到调用系统级的功能，比如内核。native表示调用底层的c/c++的库来达到目的。
         *
         * 1、首先当java执行到native修饰的方法时，会进入本地方法栈，调用本地方法接口（JNI----JAVA native interface）。
         * JNI作用：扩展java的使用，融合不同的编程语言为java所用。最初是为了调C/C++。
         * 在内存中专门开辟了一块区域（本地方法栈---native method stack。登记native方法）
         *
         * 2、执行的时候，通过本地方法接口（JNI）调用本地方法库，实现调用系统底层资源的目的。
         */

    }
}
