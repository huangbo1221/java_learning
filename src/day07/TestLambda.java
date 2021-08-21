package day07;

/**
 * @ClassName TestLambda
 * @Description 学习lambda表达式的意义
 * @Author huangbo1221
 * @Date 2021/8/21 9:58
 * @Version 1.0
 */

/**
 * 理解函数式接口（Functional interface）是理解java8 lambda表达式的关键所在
 * 函数式接口的定义：
 *     1、任何接口，如果只包含唯一一个抽象方法，那么它就是一个函数式接口
 *     2、对于函数式接口，我们可以通过lambda表达式来创建该接口的对象
 *
 * 为什么要使用lambda表达式
 *     1、避免匿名内部类定义过多
 *     2、可以让你的代码看起来更简洁、
 *     3、去掉了一堆没有意义的代码、只留下核心的逻辑
 */
public class TestLambda {

    static class StaticLambdaExmple implements LambdaExample{

        @Override
        public void lambda() {
            System.out.println("i want to know how to use lambda2 experssion!");
        }
    }

    public static void main(String[] args) {
        // 1、第一种方式调用接口的实现类
        LambdaExample lambdaExample = new MyLambda();
        lambdaExample.lambda();

        // 2、采用静态内部类来进行简化
        lambdaExample = new StaticLambdaExmple();
        lambdaExample.lambda();

        // 3、采用局部内部类来进一步简化
        class InnerLambdaExmple implements LambdaExample{

            @Override
            public void lambda() {
                System.out.println("i want to know how to use lambda3 experssion!");
            }
        }
        lambdaExample = new InnerLambdaExmple();
        lambdaExample.lambda();

        // 4、采用匿名内部类来进一步简化步骤，直接new 接口，没有具体实例的名字
        lambdaExample = new LambdaExample() {
            @Override
            public void lambda() {
                System.out.println("i want to know how to use lambda4 experssion!");
            }
        };
        lambdaExample.lambda();

        // 5、进一步加深简化，采用lambda表达式
        lambdaExample = () -> System.out.println("i want to know how to use lambda5 experssion!");
        lambdaExample.lambda();
    }
}



interface LambdaExample {
    void lambda();
}

class MyLambda implements LambdaExample{
    @Override
    public void lambda() {
        System.out.println("i want to know how to use lambda1 experssion!");
    }
}
