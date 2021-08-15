package day03.multhreadchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * @ClassName TalkSend
 * @Description 使用多线程的方式去发送消息
 * @Author huangbo1221
 * @Date 2021/8/15 18:21
 * @Version 1.0
 */
public class TalkSend implements Runnable{

    private DatagramSocket datagramSocket = null;

    private int fromPort;

    private String sendIp = null;

    private int toPort;

    private DatagramPacket datagramPacket = null;

    private BufferedReader bufferedReader = null;

    public TalkSend(int fromPort, String sendIp, int toPort) {
        this.fromPort = fromPort;
        this.sendIp = sendIp;
        this.toPort = toPort;

        try {
            datagramSocket = new DatagramSocket(fromPort);
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String datas = bufferedReader.readLine();
                byte[] sendDatas = datas.getBytes();
                // 组数包数据
                DatagramPacket datagramPacket = new DatagramPacket(sendDatas, 0, sendDatas.length, new InetSocketAddress(this.sendIp, this.toPort));
                datagramSocket.send(datagramPacket);
                if (datas.equals("bye")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        datagramSocket.close();
    }
}
