package serializable;

import java.io.*;

/**
 * @ClassName SerializableDemo1
 * @Description TODO
 * @Author huangbo1221
 * @Date 2021/11/8 21:27
 * @Version 1.0
 */
public class SerializableDemo1 {
    public static void main(String[] args) throws IOException {
//        test1_1();
//        test1_2();
        System.out.println("=========================给passwd加上transient字段后===========================");
        test2_1();
        test2_2();
    }

    public static void test1_1() throws IOException {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("D:\\projects\\java_learning\\src\\serializable\\test.txt");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            UserInfo userInfo = new UserInfo("liubo", 22, "515151", "123123");
            objectOutputStream.writeObject(userInfo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            objectOutputStream.close();
            fileOutputStream.close();
        }
    }

    public static void test1_2() throws IOException {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream("D:\\projects\\java_learning\\src\\serializable\\test.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);
            UserInfo userInfo = (UserInfo) objectInputStream.readObject();
            System.out.println(userInfo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            objectInputStream.close();
            fileInputStream.close();
        }
        // 上面的输出为：
        /**
         * UserInfo{name='liubo', age=22, id='515151', passwd='123123'}
         */
    }

    public static void test2_1() throws IOException {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("D:\\projects\\java_learning\\src\\serializable\\test1.txt");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            UserInfo userInfo = new UserInfo("liubo", 22, "515151", "123123");
            objectOutputStream.writeObject(userInfo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            objectOutputStream.close();
            fileOutputStream.close();
        }
    }

    public static void test2_2() throws IOException {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream("D:\\projects\\java_learning\\src\\serializable\\test.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);
            UserInfo userInfo = (UserInfo) objectInputStream.readObject();
            System.out.println(userInfo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            objectInputStream.close();
            fileInputStream.close();
        }
        // 上面的输出为：可见transient可以阻止某字段的序列化
        /**
         * UserInfo{name='liubo', age=22, id='515151', passwd='null'}
         */
    }
}
