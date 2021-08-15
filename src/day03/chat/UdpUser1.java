package day03.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @ClassName UdpUser1
 * @Description TODO
 * @Author huangbo1221
 * @Date 2021/8/15 17:43
 * @Version 1.0
 */
public class UdpUser1 {
    public static void main(String[] args) throws Exception {
        // 建立一个sccket
        DatagramSocket datagramSocket = new DatagramSocket();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String datas = bufferedReader.readLine();
            byte[] sendDatas = datas.getBytes();
            // 组数包数据
            DatagramPacket datagramPacket = new DatagramPacket(sendDatas, 0, sendDatas.length, new InetSocketAddress("localhost", 9090));
            datagramSocket.send(datagramPacket);
            if (datas.equals("bye")) {
                break;
            }
        }
        datagramSocket.close();
    }
}
