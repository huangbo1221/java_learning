package day02;

public interface UserService {

    // 接口中定义的常量是public static final的，必须被初始化。
    int AGE = 28;

    // 接口中的所有定义其实都是抽象的 public abstract，可以省略public abstract不写
    public abstract void add();

    void delete();

    void modify();

    void find();
}
