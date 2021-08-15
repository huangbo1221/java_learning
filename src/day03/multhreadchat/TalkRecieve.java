package day03.multhreadchat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @ClassName TalkRecieve
 * @Description 使用多线程的方式去接收消息
 * @Author huangbo1221
 * @Date 2021/8/15 18:32
 * @Version 1.0
 */
public class TalkRecieve implements Runnable{

    private int port;

    private String user = null;

    private DatagramSocket datagramSocket = null;

    public TalkRecieve(String user, int port) {
        this.port = port;
        this.user = user;
        try {
            datagramSocket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length);
                datagramSocket.receive(datagramPacket);
                String data = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                System.out.println(this.user + ": " + data);

                if (data.equals("bye")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            datagramSocket.close();
        }
    }
}
