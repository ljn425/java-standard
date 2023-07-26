package standard.ch13.thread;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadWaitEx4 {
    public static void main(String[] args) throws InterruptedException {
        TableV4 table = new TableV4();
        new Thread(new CookV4(table), "COOK1").start();
        new Thread(new CustomerV4(table, "donut"), "CUST1").start();
        new Thread(new CustomerV4(table, "burger"), "CUST2").start();

        Thread.sleep(2000);
        System.exit(0);
    }
}

class CustomerV4 implements Runnable {
    private TableV4 table;
    private String food;

    CustomerV4(TableV4 table, String food) {
        this.table = table;
        this.food = food;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            table.remove(food);
            System.out.println(Thread.currentThread().getName() + " ate a " + food);
        }
    }
}

class CookV4 implements Runnable {
    private TableV4 table;

    CookV4(TableV4 table) {
        this.table = table;
    }

    @Override
    public void run() {
        while (true) {
            // 임의의 요리를 하나 선택해서 table에 추가한다.
            int idx = (int)(Math.random() * table.dishNum()); // 0 ~ 2
            table.add(table.dishNames[idx]);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
    }
}

class TableV4 {
    String[] dishNames = {"donut", "donut", "burger"}; // donut이 더 자주 나옴
    final int MAX_FOOD = 6; // 테이블에 놓을 수 있는 최대 음식의 개수
    private ArrayList<String> dishes = new ArrayList<>();

    private ReentrantLock lock = new ReentrantLock();
    private Condition forCook = lock.newCondition();
    private Condition forCust = lock.newCondition();


    public synchronized void add(String dish) {
        lock.lock();
        // 테이블에 음식이 가득 찼으면, 테이블에 음식을 추가하지 않음
        try {
            while(dishes.size() >= MAX_FOOD) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " is waiting.");
                try {
                    forCook.await(); // COOK 쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }
            dishes.add(dish);
            forCust.signal(); // 기다리고 있는 CUSTOM 쓰레드를 깨우기 위함
            System.out.println("Dishes: " + dishes.toString());
        } finally {
            lock.unlock();
        }

    }

    public void remove(String dishName) {
        lock.lock();
        String name = Thread.currentThread().getName();

        try {
            while (dishes.size() == 0) {
                System.out.println(name + " is waiting.");
                try {
                    forCust.await(); // CUSTOM 쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }

            // 지정된 요리와 일치하는 요리를 테이블에서 제거한다.
            while(true) {
                for(int i = 0; i < dishes.size(); i++) {
                    if(dishName.equals(dishes.get(i))) {
                        dishes.remove(i);
                        forCook.signal(); // 잠자고 있는 COOK 쓰레드를 깨우기 위함
                        return;
                    }
                }
                try {
                    System.out.println(name + " is waiting.");
                    forCust.await(); // 지정된 요리가 없는 경우 CUSTOM 쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }
        } finally {
            lock.unlock();
        }
    }
    public int dishNum() {
        return dishNames.length;
    }
}
