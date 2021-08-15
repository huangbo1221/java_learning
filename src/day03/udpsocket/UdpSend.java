package day03.udpsocket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @ClassName UdpSend
 * @Description 模拟UDP协议发送请求
 * @Author huangbo1221
 * @Date 2021/8/15 17:10
 * @Version 1.0
 */
public class UdpSend {

    public static void main(String[] args) throws Exception {

        // UDP的socket通信类，建立一个socket
        DatagramSocket datagramSocket = new DatagramSocket();

        // 组装数据，装包
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9090;
        String msg = "你好啊，接收方！";
        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);
        // 发送数据包
        datagramSocket.send(datagramPacket);

        // 关闭资源
        datagramSocket.close();
    }
}
