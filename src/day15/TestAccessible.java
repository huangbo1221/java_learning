package day15;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName TestAccessible
 * @Description 测试反射里关闭安全检查时的性能
 * @Author huangbo1221
 * @Date 2021/9/9 7:47
 * @Version 1.0
 */
public class TestAccessible {
    private static void test01() {
        User user = new User();
        long startTimes = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }
        System.out.println("it costs times:" + (System.currentTimeMillis() - startTimes) + "ms");

    }

    private static void test02() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class aClass = Class.forName("day15.User");
        Method getName = aClass.getDeclaredMethod("getName", null);
        User user = (User) aClass.newInstance();
        long startTimes = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user, null);
        }
        System.out.println("it costs times:" + (System.currentTimeMillis() - startTimes) + "ms");

    }

    private static void test03() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class aClass = Class.forName("day15.User");
        Method getName = aClass.getDeclaredMethod("getName", null);
        getName.setAccessible(true);
        User user = (User) aClass.newInstance();
        long startTimes = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user, null);
        }
        System.out.println("it costs times:" + (System.currentTimeMillis() - startTimes) + "ms");

    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        test01();
        test02();
        test03();
        // 上面的输出如下:
        /**
         * it costs times:3ms
         * it costs times:1098ms
         * it costs times:830ms
         */
    }
}
