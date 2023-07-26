package standard.ch13.thread;

public class Test {
    public static void main(String[] args) {
        double random = Math.random();
        int idx = (int)(Math.random() * 3); // 0 ~ 2

        System.out.println(random);
        System.out.println(idx);
    }
}
