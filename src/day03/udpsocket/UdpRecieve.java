package day03.udpsocket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @ClassName UdpRecieve
 * @Description TODO
 * @Author huangbo1221
 * @Date 2021/8/15 17:21
 * @Version 1.0
 */
public class UdpRecieve {

    public static void main(String[] args) throws Exception {

        // 开放端口
        DatagramSocket datagramSocket = new DatagramSocket(9090);

        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length);

        // 以datagramPacket的方式去接收数据包。阻塞方式的接收
        datagramSocket.receive(datagramPacket);

        // 打印信息
        System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));

        // 资源的关闭
        datagramSocket.close();

    }
}
