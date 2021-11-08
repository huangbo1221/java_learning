package day01;

public class Child  extends Father{

    public static void testMethod() {
        System.out.println("i'm child static method");
    }

    @Override
    public void test() {
        System.out.println("i'm child test method");
    }

}
