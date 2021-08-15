package day03.multhreadchat;

/**
 * @ClassName Student
 * @Description TODO
 * @Author huangbo1221
 * @Date 2021/8/15 18:37
 * @Version 1.0
 */
public class Student {
    public static void main(String[] args) {
        new Thread(new TalkSend(6666, "localhost", 9999)).start();
        new Thread(new TalkRecieve("老师", 8888)).start();
    }
}
