package day03.multhreadchat;

/**
 * @ClassName Tearch
 * @Description TODO
 * @Author huangbo1221
 * @Date 2021/8/15 18:35
 * @Version 1.0
 */
public class Teacher {

    public static void main(String[] args) {
        new Thread(new TalkSend(5555, "localhost", 8888)).start();
        new Thread(new TalkRecieve("学生", 9999)).start();
    }
}
