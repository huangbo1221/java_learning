package day08.syn;

/**
 * @ClassName UnSafeBank
 * @Description 模拟银行取钱
 * @Author huangbo1221
 * @Date 2021/8/22 11:53
 * @Version 1.0
 */

/**
 * 直接在public synchronized void run()方法上加synchronized修饰符，
 * 此时锁的是new出来的DrawMoneySafe对象，但是在“你”、“你老婆”、“你妈”是new出来了三个对象，此时的输出为
 * outputs:
 * 你妈无法取钱，钱不够了
 * 你取了50万，剩下0万
 * 你老婆取了20万，剩下0万
 * 可见仍是不安全的，因为不是同一个锁！！！
 *
 * 修改如下：应该用synchronized去锁bank对象，因为是对bank对象进行操作
 * 此时的outputs：
 * 你取了50万，剩下0万
 * 你妈无法取钱，钱不够了
 * 你老婆无法取钱，钱不够了
 */
public class SafeBank {
    public static void main(String[] args) {
        Bank bank = new Bank(50, "结婚基金");

        new Thread(new DrawMoneySafe(bank, 50, "你")).start();
        new Thread(new DrawMoneySafe(bank, 20, "你老婆")).start();
        new Thread(new DrawMoneySafe(bank, 100, "你妈")).start();
    }
}

class Bank2 {
    public int getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    private int currentMoney;

    private String account;

    public Bank2(int currentMoney, String account) {
        this.currentMoney = currentMoney;
        this.account = account;
    }
}

class DrawMoneySafe extends Thread {
    private Bank bank;

    private String name;

    private int money;

    DrawMoneySafe(Bank bank, int money, String name) {
        super(name);
        this.bank = bank;
        this.money = money;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (bank) {
            if (bank.getCurrentMoney() - money < 0) {
                System.out.println(this.getName() + "无法取钱，钱不够了");
                return;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bank.setCurrentMoney(bank.getCurrentMoney() - money);
            System.out.println(this.getName() + "取了" + money + "万，" + "剩下" + bank.getCurrentMoney() + "万");
        }
    }

//    @Override
//    public synchronized void run() {
//        if (bank.getCurrentMoney() - money < 0) {
//            System.out.println(this.getName() + "无法取钱，钱不够了");
//            return;
//        }
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        bank.setCurrentMoney(bank.getCurrentMoney() - money);
//        System.out.println(this.getName() + "取了" + money + "万，" + "剩下" + bank.getCurrentMoney() + "万");
//    }

}
