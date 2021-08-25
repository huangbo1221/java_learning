package java.lang;

/**
 * @ClassName String
 * @Description TODO
 * @Author huangbo1221
 * @Date 2021/8/25 21:37
 * @Version 1.0
 */

/**
 * 输出：
 * 错误: 在类 java.lang.String 中找不到 main 方法, 请将 main 方法定义为:
 *    public static void main(String[] args)
 * 否则 JavaFX 应用程序类必须扩展javafx.application.Application
 *
 * 双亲委派机制
 *
 * 解释：
 * 1、类加载器收到类加载的请求
 * 2、将这个请求向上委托给父类加载器去完成，一直向上委托，直到启动类加载器
 * 3、启动加载器检查是否能够加载当前这个类，能加载就结束，使用当前的类加载器。否则，抛出异常，通知子加载器进行加载
 * 4、重复步骤3
 *
 * 该类的输出是因为加载到了rt.jar包的String类，但是该类没有main
 */
public class String {

    public String toString() {
        return "Hello";
    }

    public static void main(String[] args) {
        String str = new String();
        System.out.println(str.toString());
    }
}
