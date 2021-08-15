package day03.thread;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @ClassName ThreadDownloadImages
 * @Description 多线程的运行结果与代码顺序无关，与CPU的调度密切相关
 * @Author huangbo1221
 * @Date 2021/8/15 22:07
 * @Version 1.0
 */
public class ThreadDownloadImages extends Thread{
    private String url;

    private String name;

    public ThreadDownloadImages(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        ImageDownload imageDownload = new ImageDownload();
        imageDownload.downloadImages(url, name);
        System.out.println(name + "下载图片成功");
    }

    public static void main(String[] args) {

        ThreadDownloadImages t1 = new ThreadDownloadImages("https://img0.baidu.com/it/u=1901509370,3531703694&fm=26&fmt=auto&gp=0.jpg", "1.jpg");
        ThreadDownloadImages t2 = new ThreadDownloadImages("http://www.keaitupian.cn/uploads/allimg/210728/154T043H-0.jpg", "2.jpg");
        ThreadDownloadImages t3 = new ThreadDownloadImages("http://img.keaitupian.cn/uploads/2021/06/19/15300859888593580.jpg", "3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }
}

class ImageDownload {

    public void downloadImages(String url, String name) {
        try {
            URL url1 = new URL(url);
            File file = new File(name);
            FileUtils.copyURLToFile(url1, file);
        } catch (IOException e) {
            System.out.println("图片下载失败");
            e.printStackTrace();
        }
    }
}
