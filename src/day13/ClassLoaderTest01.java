package day13;

/**
 * @ClassName ClassLoaderTest01
 * @Description 获取类的加载器
 * @Author huangbo1221
 * @Date 2021/9/7 7:44
 * @Version 1.0
 */
public class ClassLoaderTest01 {

    public static void main(String[] args) throws ClassNotFoundException {

        // 获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        // 获取系统类加载器的父类加载器 --> 扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);
        // 获取扩展类加载器的父类加载器 --> 根加载器(C/C++)
        // 底层语言编写，获取不到
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
        // 上面代码的输出如下
        /**
         * sun.misc.Launcher$AppClassLoader@18b4aac2
         * sun.misc.Launcher$ExtClassLoader@74a14482
         * null
         */

        // 获取当前类的类加载器
        ClassLoader classLoader = Class.forName("day13.ClassLoaderTest01").getClassLoader();
        System.out.println(classLoader);
        // 获取Object类的加载器（测试JDK内置的类是哪个类加载器加载的）
        ClassLoader aClass = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(aClass);
        // 输出如下：
        /**
         * sun.misc.Launcher$AppClassLoader@18b4aac2
         * null
         */

        // 获取系统类加载器的所有加载路径
        System.out.println(System.getProperty("java.class.path"));;
        /**
         * 路径如下：
         * D:\software\jdk\jre\lib\charsets.jar;
         * D:\software\jdk\jre\lib\deploy.jar;
         * D:\software\jdk\jre\lib\ext\access-bridge-64.jar;
         * D:\software\jdk\jre\lib\ext\cldrdata.jar;
         * D:\software\jdk\jre\lib\ext\dnsns.jar;
         * D:\software\jdk\jre\lib\ext\jaccess.jar;
         * D:\software\jdk\jre\lib\ext\jfxrt.jar;
         * D:\software\jdk\jre\lib\ext\localedata.jar;
         * D:\software\jdk\jre\lib\ext\nashorn.jar;
         * D:\software\jdk\jre\lib\ext\sunec.jar;
         * D:\software\jdk\jre\lib\ext\sunjce_provider.jar;
         * D:\software\jdk\jre\lib\ext\sunmscapi.jar;
         * D:\software\jdk\jre\lib\ext\sunpkcs11.jar;
         * D:\software\jdk\jre\lib\ext\zipfs.jar;
         * D:\software\jdk\jre\lib\javaws.jar;
         * D:\software\jdk\jre\lib\jce.jar;
         * D:\software\jdk\jre\lib\jfr.jar;
         * D:\software\jdk\jre\lib\jfxswt.jar;
         * D:\software\jdk\jre\lib\jsse.jar;
         * D:\software\jdk\jre\lib\management-agent.jar;
         * D:\software\jdk\jre\lib\plugin.jar;
         * D:\software\jdk\jre\lib\resources.jar;
         * D:\software\jdk\jre\lib\rt.jar;
         * D:\projects\java_learning\out\production\java_learning;
         * D:\projects\java_learning\src\lib\commons-io-2.11.0.jar;
         * D:\software\intel_idea\IntelliJ IDEA 2021.2\lib\idea_rt.jar
         */
    }
}
