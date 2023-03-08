package standard.ch8;

public class ExceptionEx3 {
    public static void main(String[] args) {
        int number = 100;

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(number / (int) (Math.random() * 10));
            } catch (ArithmeticException e) {
                System.out.println("ArithmeticException 예외발생 : " + e);
            }

        }
    }
}
