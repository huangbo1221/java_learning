package day14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectionTestDay14
 * @Description 通过反射来创建类，获取类的属性
 * @Author huangbo1221
 * @Date 2021/9/8 8:00
 * @Version 1.0
 */
public class ReflectionTestDay14 {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class aClass = Class.forName("day14.User");
        System.out.println(aClass.newInstance());
        // 输出如下：
        /**
         * day15.User{name='null', id=0, age=0}
         */
        System.out.println("======================");
        System.out.println(aClass.getDeclaredConstructor().newInstance());
        // 输出如下：
        /**
         * day15.User{name='null', id=0, age=0}
         */
        // 可知：本质上上面两个获取对象实例的方法是调用了User类的无参构造方法

        Constructor declaredConstructor = aClass.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println(declaredConstructor);
//        day15.User user1 = (day15.User) declaredConstructor.newInstance("huangbo1221", 12, 12);
//        System.out.println(user1);
        // 上面的输出如下：可知，getDeclaredConstructor虽然可以获取到本类指定的构造方法，包括私有的。但是针对私有的构造方法，不能实例化对象
        /**
         * day15.User{name='null', id=0, age=0}
         * ======================
         * day15.User{name='null', id=0, age=0}
         * private day14.day15.User(java.lang.String,int,int)
         * Exception in thread "main" java.lang.IllegalAccessException: Class day14.ReflectionTestDay14 can not access a member of class day14.day15.User with modifiers "private"
         * 	at sun.reflect.Reflection.ensureMemberAccess(Reflection.java:102)
         * 	at java.lang.reflect.AccessibleObject.slowCheckMemberAccess(AccessibleObject.java:296)
         * 	at java.lang.reflect.AccessibleObject.checkAccess(AccessibleObject.java:288)
         * 	at java.lang.reflect.Constructor.newInstance(Constructor.java:413)
         * 	at day14.ReflectionTestDay14.main(ReflectionTestDay14.java:32)
         */

        // 将私有的构造方法改成公有的再进行测试
        User user2 = (User) declaredConstructor.newInstance("huangbo1221", 12, 12);
        System.out.println(user2);
        // 上面的输出如下
        /**
         * day15.User{name='null', id=0, age=0}
         * ======================
         * day15.User{name='null', id=0, age=0}
         * public day14.day15.User(java.lang.String,int,int)
         * day15.User{name='huangbo1221', id=12, age=12}
         */

        System.out.println("========================================");
        User user3 = (User) aClass.newInstance();
        Method setName = aClass.getDeclaredMethod("setName", String.class);
        setName.invoke(user3, "liubo");
        System.out.println(user3);
        // 上面的所有输出如下：
        /**
         * day15.User{name='null', id=0, age=0}
         * ======================
         * day15.User{name='null', id=0, age=0}
         * public day14.day15.User(java.lang.String,int,int)
         * day15.User{name='huangbo1221', id=12, age=12}
         * ========================================
         * day15.User{name='liubo', id=0, age=0}
         */

        System.out.println("==============================");
        Field id = aClass.getDeclaredField("id");
        // 直接针对私有属性设置值
//        id.set(user3, 15);
        System.out.println(user3);
        // 上面的打印输出如下：可知，私有属性无法访问
        /**
         * Exception in thread "main" java.lang.IllegalAccessException: Class day14.ReflectionTestDay14 can not access a member of class day14.day15.User with modifiers "private"
         * 	at sun.reflect.Reflection.ensureMemberAccess(Reflection.java:102)
         * 	at java.lang.reflect.AccessibleObject.slowCheckMemberAccess(AccessibleObject.java:296)
         * 	at java.lang.reflect.AccessibleObject.checkAccess(AccessibleObject.java:288)
         * 	at java.lang.reflect.Field.set(Field.java:761)
         * 	at day14.ReflectionTestDay14.main(ReflectionTestDay14.java:80)
         */

        System.out.println("==============================");
        // 放开安全检查，使其变得可访问，直接针对私有属性设置值
        id.setAccessible(true);
        id.set(user3, 15);
        System.out.println(user3);
        // 上面的输出如下:
        /**
         * day15.User{name='liubo', id=15, age=0}
         */
    }

}


class User {
    public String name;

    private int id;

    private int age;

    public User() {
    }

    public User(String name, int id, int age) {
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
