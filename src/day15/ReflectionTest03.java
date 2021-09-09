package day15;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @ClassName ReflectionTest03
 * @Description 练习反射
 * @Author huangbo1221
 * @Date 2021/9/9 8:09
 * @Version 1.0
 */
public class ReflectionTest03 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class aClass = Class.forName("day15.Student");
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        // 上面的for循环输出如下：
        /**
         * @day15.TabStudent(value=huangbo1221)
         */
        System.out.println("=============================================");
        Annotation annotation = aClass.getAnnotation(TabStudent.class);
        System.out.println(annotation);
        // 上面的输出如下：
        /**
         * @day15.TabStudent(value=huangbo1221)
         */
        System.out.println("=============================================");
        // 直接来获取注解的名称，下面获取到类的注解后强转
        TabStudent tabStudent = (TabStudent) aClass.getAnnotation(TabStudent.class);
        System.out.println(tabStudent.value());
        // 上面的输出如下：
        /**
         * huangbo1221
         */

        System.out.println("==========================================");
        // 如何获取属性上的注解名称
        Field name = aClass.getDeclaredField("name");
        System.out.println(name);
        FiledStudent annotation1 = name.getAnnotation(FiledStudent.class);
        System.out.println(annotation1.columnName());
        System.out.println(annotation1.type());
        System.out.println(annotation1.length());
        // 上面的输出如下：
        /**
         * private java.lang.String day15.Student.name
         * db_name
         * varchar
         * 10
         */
    }

}

@TabStudent("huangbo1221")
class Student {

    @FiledStudent(columnName = "db_name", type = "varchar", length = 10)
    private String name;

    @FiledStudent(columnName = "db_age", type = "int", length = 3)
    private int age;

    @FiledStudent(columnName = "db_uid", type = "int", length = 15)
    private int uid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", uid=" + uid +
                '}';
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TabStudent {
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FiledStudent {
    String columnName();

    String type();

    int length();
}