/**
 *
 * 下面的输出为
 * i'm child test method
 * i'm father static method
 * i'm father static method
 *
 * 1、证明父类的静态方法不可以被子类重写（override），若重写，编译时会报错。
 * 但是可以在子类写一个同样的静态方法，调用时起不到多态的作用，输出什么是由
 * 父类或者子类来引用时决定的
 *
 * 2、父类的私有方法不可被重写，否则编译时就报错
 *
 */
package day01;

public class Day01 {

    public static void main(String[] args) {

        Father father = new Child();
        father.test();
        father.testMethod();

        Child child = new Child();
        child.testMethod();

        // 上面的输出如下：多态场景下（父类对象指向子类的实例时），调用重名静态方法仍是父类的静态方法
        /**
         * i'm child test method
         * i'm father static method
         * i'm child static method
         */


    }
}
