package day11;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName MyAnnotation
 * @Description 了解下元注解和自定义注解。元注解：@Target、@Retention、@Documented、@Inherited
 * @Author huangbo1221
 * @Date 2021/8/30 23:29
 * @Version 1.0
 */
public class MyAnnotation {

    @CustomAnnotion(name = "huangbo1221", age = 0)
    public void test() {

    }

}

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface CustomAnnotion {
    // 这种定义方式不是方法，而是定义的属性，规定的格式就是这样
    String name();
    int age();
}
