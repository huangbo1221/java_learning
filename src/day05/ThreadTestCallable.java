package day05;

import day03.thread.ThreadDownloadImages;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @ClassName ThreadTestCallable
 * @Description 实现多线程方式之三：实现callable接口
 * @Author huangbo1221
 * @Date 2021/8/17 22:24
 * @Version 1.0
 */

// callabel的好处:1、可以定义返回值；2、可以抛出异常
public class ThreadTestCallable implements Callable<Boolean> {

    private String url;

    private String name;

    public ThreadTestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        new TestDownload().download(this.url, this.name);
        System.out.println("图片名称为：" + this.name+ "被成功下载");
        return true;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadTestCallable t3 = new ThreadTestCallable("https://img0.baidu.com/it/u=1901509370,3531703694&fm=26&fmt=auto&gp=0.jpg", "1.jpg");
        ThreadTestCallable t2 = new ThreadTestCallable("http://www.keaitupian.cn/uploads/allimg/210728/154T043H-0.jpg", "2.jpg");
        ThreadTestCallable t1 = new ThreadTestCallable("http://img.keaitupian.cn/uploads/2021/06/19/15300859888593580.jpg", "3.jpg");

        // 创建执行服务：
        ExecutorService es = Executors.newFixedThreadPool(3);

        // 提交执行
        Future<Boolean> rs1 = es.submit(t3);
        Future<Boolean> rs2= es.submit(t2);
        Future<Boolean> rs3 = es.submit(t1);

        // 获取结果
        System.out.println(rs1.get());
        System.out.println(rs2.get());
        System.out.println(rs3.get());

        // 关闭服务
        es.shutdown();
    }
}



class TestDownload {

    public void download(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            System.out.println("图片下载失败!");
            e.printStackTrace();
        }

    }

}
