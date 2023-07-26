package standard.ch13.thread;

import java.util.Iterator;
import java.util.Map;

public class ThreadEx11 {
    public static void main(String[] args) {
        new ThreadEx11_1("Thread1").start();
        new ThreadEx11_2("Thread2").start();

    }
}

class ThreadEx11_1 extends Thread {
    public ThreadEx11_1(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadEx11_2 extends Thread {
    public ThreadEx11_2(String name) {
        super(name);
    }

    @Override
    public void run() {
        Map map = getAllStackTraces(); // 모든 쓰레드의 `StackTrace`를 Map 형태로 반환한다.
        Iterator it = map.keySet().iterator(); // 모든 쓰레드의 `StackTrace`를 출력한다.

        int x = 0;
        while (it.hasNext()) {
            Object obj = it.next(); // 쓰레드의 이름을 반환한다.
            Thread t = (Thread) obj;
            StackTraceElement[] ste = (StackTraceElement[]) (map.get(obj));

            System.out.println("[" + ++x + "] name : " + t.getName() + ", group : " + t.getThreadGroup().getName() + ", daemon : " + t.isDaemon());
            for (int i = 0; i < ste.length; i++) {
                System.out.println(ste[i]);
            }

            System.out.println();

        }
    }
}
