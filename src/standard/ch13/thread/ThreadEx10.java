package standard.ch13.thread;

import static java.lang.Thread.sleep;

public class ThreadEx10 implements Runnable {
    static boolean autoSave = false;

    public static void main(String[] args) {
        Thread t = new Thread(new ThreadEx10());
        // setDemon 메서드는 반드시 start() 메서드 호출 전에 실행되어야 한다. 그렇지 않으면 IllegalThreadStateException 발생
        t.setDaemon(true);
        t.start();

        for (int i = 1; i < 10; i++) {
            try {
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(i);

            if (i == 5) {
                autoSave = true;
            }
        }
    }

    public void run() {
        while(true) {
            try {
                sleep(3 * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (autoSave) {
                autoSave();
            }
        }
    }
    private void autoSave() {
        System.out.println("작업파일이 자동저장되었습니다.");
    }

}


