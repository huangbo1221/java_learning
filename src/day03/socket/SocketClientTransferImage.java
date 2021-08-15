package day03.socket;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @ClassName SocketClientTransferImage
 * @Description socket通信，传输一张图片
 * @Author huangbo1221
 * @Date 2021/8/15 12:48
 * @Version 1.0
 */
public class SocketClientTransferImage {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
        OutputStream outputStream = socket.getOutputStream();

        // 确定要读取的文件
        FileInputStream fileInputStream = new FileInputStream(new File("xuexi.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0 , len);
        }

        fileInputStream.close();
        outputStream.close();
        socket.close();


    }




}
