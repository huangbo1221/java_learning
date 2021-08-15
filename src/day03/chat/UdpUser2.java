package day03.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @ClassName UdpUser2
 * @Description TODO
 * @Author huangbo1221
 * @Date 2021/8/15 17:55
 * @Version 1.0
 */
public class UdpUser2 {

    public static void main(String[] args) throws Exception {

        // 建立端口
        DatagramSocket datagramSocket = new DatagramSocket(9090);

        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length);
        while (true) {
            datagramSocket.receive(datagramPacket);
            String data = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println(data);

            if (data.equals("bye")) {
                break;
            }
        }
        datagramSocket.close();

    }
}
