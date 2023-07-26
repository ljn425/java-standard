package standard.ch13.thread;

import java.util.ArrayList;

public class ThreadWaitEx3 {
    public static void main(String[] args) throws InterruptedException {
        TableV3 table = new TableV3();
        new Thread(new CookV3(table), "COOK1").start();
        new Thread(new CustomerV3(table, "donut"), "CUST1").start();
        new Thread(new CustomerV3(table, "burger"), "CUST2").start();

        Thread.sleep(2000);
        System.exit(0);
    }
}

class CustomerV3 implements Runnable {
    private TableV3 table;
    private String food;

    CustomerV3(TableV3 table, String food) {
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

class CookV3 implements Runnable {
    private TableV3 table;

    CookV3(TableV3 table) {
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

class TableV3 {
    String[] dishNames = {"donut", "donut", "burger"}; // donut이 더 자주 나옴
    final int MAX_FOOD = 6; // 테이블에 놓을 수 있는 최대 음식의 개수
    private ArrayList<String> dishes = new ArrayList<>();

    public synchronized void add(String dish) {
        // 테이블에 음식이 가득 찼으면, 테이블에 음식을 추가하지 않음
        while(dishes.size() >= MAX_FOOD) {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is waiting.");
            try {
                wait(); // COOK 쓰레드를 기다리게 한다.
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
        dishes.add(dish);
        notify(); // 기다리고 있는 CUSTOM 쓰레드를 깨우기 위함
        System.out.println("Dishes: " + dishes.toString());
    }

    public void remove(String dishName) {
        synchronized(this) {
            String name = Thread.currentThread().getName();

            while (dishes.size() == 0) {
                System.out.println(name + " is waiting.");
                try {
                    wait(); // CUSTOM 쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }

            // 지정된 요리와 일치하는 요리를 테이블에서 제거한다.
            while(true) {
                for(int i = 0; i < dishes.size(); i++) {
                    if(dishName.equals(dishes.get(i))) {
                        dishes.remove(i);
                        notify(); // 잠자고 있는 COOK 쓰레드를 깨우기 위함
                        return;
                    }
                }
                try {
                    System.out.println(name + " is waiting.");
                    wait(); // 지정된 요리가 없는 경우 CUSTOM 쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }

        }
    }
    public int dishNum() {
        return dishNames.length;
    }
}
