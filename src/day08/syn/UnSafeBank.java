package day08.syn;

/**
 * @ClassName UnSafeBank
 * @Description 模拟银行取钱
 * @Author huangbo1221
 * @Date 2021/8/22 11:53
 * @Version 1.0
 */

/**
 * outputs:
 * 你妈无法取钱，钱不够了
 * 你老婆取了20万，剩下30万
 * 你取了50万，剩下30万
 */
public class UnSafeBank {
    public static void main(String[] args) {
        Bank bank = new Bank(50, "结婚基金");

        new Thread(new DrawMoney(bank, 50, "你")).start();
        new Thread(new DrawMoney(bank, 20, "你老婆")).start();
        new Thread(new DrawMoney(bank, 100, "你妈")).start();
    }
}

class Bank {
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

    public Bank(int currentMoney, String account) {
        this.currentMoney = currentMoney;
        this.account = account;
    }
}

class DrawMoney extends Thread {
    private Bank bank;

    private String name;

    private int money;

    DrawMoney(Bank bank, int money, String name) {
        super(name);
        this.bank = bank;
        this.money = money;
        this.name = name;
    }

    @Override
    public void run() {
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
