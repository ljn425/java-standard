package standard.ch13.thread;

public class ThreadEx21 {
    public static void main(String[] args) {
        RunnableEx22 r = new RunnableEx22();
        new Thread(r).start();
        new Thread(r).start();
    }
}

class Account {
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int money) {
        if(balance >= money) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            balance -= money;
        }
    }
}

class RunnableEx21 implements Runnable {
    Account_2 acc = new Account_2();

    @Override
    public void run() {
        while(acc.getBalance() > 0) {
            // 100, 200, 300 중의 한 값을 임의로 선택해서 출금(withdraw)
            int money = (int)(Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance: " + acc.getBalance());
        }
    }
}
