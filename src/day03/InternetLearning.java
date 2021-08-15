package day03;

import java.net.InetSocketAddress;

/**
 * @ClassName InternetLearning
 * @Description 网络编程
 * @Author huangbo1221
 * @Date 2021/8/15 10:55
 * @Version 1.0
 */
public class InternetLearning {

    public static void main(String[] args) {

        InetSocketAddress localhost = new InetSocketAddress("localhost", 8080);

        System.out.println(localhost.getAddress());
        System.out.println(localhost.getHostName());
        System.out.println(localhost.getPort());



    }

}
