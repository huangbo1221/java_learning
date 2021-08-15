package day03.socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName SocketServer
 * @Description 模拟socket通信服务端
 * @Author huangbo1221
 * @Date 2021/8/15 11:57
 * @Version 1.0
 */
public class SocketServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        // 创建一个socket地址，首先得有地址，客户端才能去连
        try {
            serverSocket = new ServerSocket(9999);
            while (true) {
                // 等同于客户端创建的socket
                accept = serverSocket.accept();
                // 直接用这个流去进行读取，然后输出的话，可能会出现乱码
                inputStream = accept.getInputStream();

                // 用byteArrayOutputStream包装一层，避免乱码
                byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0 , len);
                }
                System.out.println(byteArrayOutputStream.toString());
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
