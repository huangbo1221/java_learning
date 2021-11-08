package day02;

/**
 * @ClassName Application
 * @Description 测试主类
 * @Author huangbo1221
 * @Date 2021/8/14 16:04
 * @Version 1.0
 */
public class Application {

    public static void main(String[] args) {
        Child child = new Child();
        // 执行上面这句，输出为
        // person name: this.name   age: 5
        // create a child!
        // 1、说明在子类的构造方法里，隐式的调用了super();方法来执行父类的无惨构造方法
        // 2、当父类的构造方法只有有参构造方法时，若子类不显示调用super(参数)来执行父类的
        // 构造方法，编译会报错。当给父类有参构造方法后，一般是要显示的写出无参构造方法。
        // 3、super()方法必须出现在子类构造方法的第一句，否则编译报错！！！

        child.test("huangbo1221");
        // huangbo1221
        // child
        // father


        // 加深理解多态
        // 问题1：父类的引用变量指向的子类实例，能否调用子类独有的public方法？
        // 答案：不能！
        Father father = new Child();
//        father.test(); // 这句无法通过编译
    }
}
