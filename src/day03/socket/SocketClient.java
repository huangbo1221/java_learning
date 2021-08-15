package day03.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName SocketClient
 * @Description 模拟socket通信客户端
 * @Author huangbo1221
 * @Date 2021/8/15 11:57
 * @Version 1.0
 */
public class SocketClient {

    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            // 1、获取服务端地址和端口号
            InetAddress serverIp = InetAddress.getByName("127.0.0.1");
            int port = 9999;

            // 创建一个socket，用于连接服务器
            socket = new Socket(serverIp, port);
            // 输出流
            outputStream = socket.getOutputStream();

            outputStream.write("你好啊，java的socket通信！".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
