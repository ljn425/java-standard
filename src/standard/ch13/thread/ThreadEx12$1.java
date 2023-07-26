package standard.ch13.thread;

public class ThreadEx12$1 {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("group1");// 쓰레드 그룹 생성
        ThreadEx12$1_1 th1 = new ThreadEx12$1_1(group);
        ThreadEx12$1_2 th2 = new ThreadEx12$1_2(group);

        th1.start();
        th2.start();

        try {
            th1.sleep(2000);
        } catch (InterruptedException e) {

        }
        System.out.println("<<main 종료>>");
    }

}

class ThreadEx12$1_1 extends Thread {
    public ThreadEx12$1_1(ThreadGroup group) {
        super(group, "th1"); // 쓰레드 그룹에 속한 쓰레드 이름 지정
    }

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("-"));
        }
        System.out.println("<<th1 종료>>");
    }
}

class ThreadEx12$1_2 extends Thread {
    public ThreadEx12$1_2(ThreadGroup group) {
        super(group, "th2"); // 쓰레드 그룹에 속한 쓰레드 이름 지정
    }

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("|"));
        }
        System.out.println("<<th2 종료>>");
    }
}

