package day03.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName SocketServerRecieveImage
 * @Description socket通信，接收一张图片
 * @Author huangbo1221
 * @Date 2021/8/15 12:48
 * @Version 1.0
 */
public class SocketServerRecieveImage {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();

        FileOutputStream fileOutputStream = new FileOutputStream(new File("recieve.jpg"));

        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, len);
        }

        // 增加步骤，服务器要确认已经接收完毕，反馈给客户端
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("服务器已经接收完毕！".getBytes());

        // 关闭资源
        fileOutputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();


    }

}
