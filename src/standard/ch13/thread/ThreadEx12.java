package standard.ch13.thread;

public class ThreadEx12 {
    public static void main(String[] args) {
        ThreadEx12_1 th1 = new ThreadEx12_1();
        ThreadEx12_2 th2 = new ThreadEx12_2();

        th1.start();
        th2.start();

        try {
            th1.sleep(2000);
        } catch (InterruptedException e) {

        }

        System.out.println("<<main 종료>>");
    }
}

class ThreadEx12_1 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("-"));
        }
        System.out.println("<<th1 종료>>");
    }
}

class ThreadEx12_2 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("|"));
        }
        System.out.println("<<th2 종료>>");
    }
}