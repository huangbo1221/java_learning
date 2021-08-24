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
 *
 * 解释：
 * 前面三个之所以不一样，是因为testClassLoader1和testClassLoader2、testClassLoader3
 * 是三个不同的实例化对象。
 * 而testClassLoader1.getClass()是返回最初的模板类，上面的三个类都是由一个模板类new出来的
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
    }
}
