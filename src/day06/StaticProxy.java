package day06;

/**
 * @ClassName StaticProxy
 * @Description 知道什么事静态代理
 * @Author huangbo1221
 * @Date 2021/8/18 21:50
 * @Version 1.0
 */

// 静态代理模式的总结:
// 1、真实对象和代理对象都要实现同一个接口 2、代理对象要代理真实角色
// 好处：
// 1、代理对象可以做很多真实对象做不了的事情 2、真实对象专注做自己的事情
public class StaticProxy {

    public static void main(String[] args) {

        System.out.println("你自己写论文");
        new You().writePaper();

        System.out.println("========================---");

        System.out.println("你想找个公司代替你写论文");
        new PaperCompany(new You()).writePaper();

        // 对比Thread的静态代理
        new Thread(() -> System.out.println("恭喜你")).start();
    }

}



// 论文撰写接口
interface PaperWriting {

    // 写论文
    public void writePaper();

}

// 你要写论文
class You implements PaperWriting {

    @Override
    public void writePaper() {
        System.out.println("你要写论文啦！");
    }
}

// 论文代写公司
class PaperCompany implements PaperWriting {

    // 论文公司不会自己无缘无故写论文，得找到需要代写的目标
    private PaperWriting target;

    public PaperCompany(PaperWriting target) {
        this.target = target;
    }

    @Override
    public void writePaper() {
        before();
        this.target.writePaper();
        after();
    }

    // 不可能无缘无故就帮你写论文，得先谈价格
    public void before() {
        System.out.println("你得先付3000块钱，定金先付1500.");
    }

    public void after() {
        System.out.println("把剩下的1500赶紧给公司！");
    }
}
