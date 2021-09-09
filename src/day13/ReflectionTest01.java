package day13;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectionTest01
 * @Description 获取类的运行时结构
 * @Author huangbo1221
 * @Date 2021/9/7 8:09
 * @Version 1.0
 */
public class ReflectionTest01 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class aClass = Class.forName("day13.User");
        // 获取包名+类名
        System.out.println(aClass.getName());
        // 获取类名
        System.out.println(aClass.getSimpleName());
        // 上面输出如下
        /**
         * day13.day15.User
         * day15.User
         */

        System.out.println("================");
        Field[] fields = aClass.getFields();
        for (Field field:fields) {
            System.out.println(field);
        }
        // 上面的for循环输出如下：可知，只能获取到类的public属性
        /**
         * public java.lang.String day13.day15.User.name
         */

        System.out.println("======================");
        fields = aClass.getDeclaredFields();
        for (Field field:fields) {
            System.out.println(field);
        }
        // 上面的for循环输出如下：可知，能获取到类所有声明的属性
        /**
         * public java.lang.String day13.day15.User.name
         * private int day13.day15.User.id
         * private int day13.day15.User.age
         */

        System.out.println("============================");
        System.out.println(aClass.getField("name"));
//        System.out.println(aClass.getField("age"));
        // 上面这一行输出如下：可知，getField只能获取到公有属性
        /**
         * public java.lang.String day13.day15.User.name
         * Exception in thread "main" java.lang.NoSuchFieldException: age
         * 	at java.lang.Class.getField(Class.java:1703)
         * 	at day13.ReflectionTest01.main(ReflectionTest01.java:49)
         */

        System.out.println("==========================");
        // 获取类的方法
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        // 上面的for循环输出如下：可知，getMethods方法可以获取本类及父类的全部public方法
        /**
         * public java.lang.String day13.day15.User.toString()
         * public java.lang.String day13.day15.User.getName()
         * public void day13.day15.User.setName(java.lang.String)
         * public void day13.day15.User.setAge(int)
         * public void day13.day15.User.setId(int)
         * public final void java.lang.Object.wait() throws java.lang.InterruptedException
         * public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
         * public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
         * public boolean java.lang.Object.equals(java.lang.Object)
         * public native int java.lang.Object.hashCode()
         * public final native java.lang.Class java.lang.Object.getClass()
         * public final native void java.lang.Object.notify()
         * public final native void java.lang.Object.notifyAll()
         */

        System.out.println("===========================");
        methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        // 上面的for循环输出如下：可知，getDeclaredMethods方法可以获取本类所有声明的方法
        /**
         * public java.lang.String day13.day15.User.toString()
         * public java.lang.String day13.day15.User.getName()
         * private int day13.day15.User.getId()
         * public void day13.day15.User.setName(java.lang.String)
         * private int day13.day15.User.getAge()
         * public void day13.day15.User.setAge(int)
         * public void day13.day15.User.setId(int)
         */

        System.out.println("============================");
        // 获得指定的方法
        System.out.println(aClass.getMethod("getName", null));
        System.out.println(aClass.getMethod("setName", String.class));
        // 上面的输出如下：getmethod必须加参数，要考虑函数重载的情况！
        /**
         * public java.lang.String day13.day15.User.getName()
         * public void day13.day15.User.setName(java.lang.String)
         */

        System.out.println("=================================");
        // 获取构造器
        Constructor[] constructors = aClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        // 上面的for循环输出如下：可知，只能获取public的构造器
        /**
         * public day13.day15.User()
         */

        System.out.println("===================================");
        constructors = aClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        // 上面的for循环输出如下：可知，可以获取本类所有构造器
        /**
         * public day13.day15.User()
         * public day13.day15.User(java.lang.String,int,int)
         */

        System.out.println("===================================");
        //获取指定构造器
        System.out.println(aClass.getDeclaredConstructor(String.class, int.class, int.class));
        // 上面一行输出如下：
        /**
         * private day13.day15.User(java.lang.String,int,int)
         */
    }
}

class User {
    public String name;

    private int id;

    private int age;

    public User() {
    }

    private User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "day15.User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
