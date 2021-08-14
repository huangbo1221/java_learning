package day02;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author huangbo1221
 * @Date 2021/8/14 17:58
 * @Version 1.0
 */
public class UserServiceImpl implements UserService, TimerService{
    @Override
    public void add() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void modify() {

    }

    @Override
    public void find() {

    }

    @Override
    public void timer() {

    }

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.timer();
    }
}
