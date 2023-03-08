package standard.ch8;

/**
 * ArithmeticException / by zero
 */
public class ExceptionEx2 {
    public static void main(String[] args) {
        int number = 100;
        int result = 0;

        for(int i=0; i<10; i++) {
            int t = (int) (Math.random() * 10);
            System.out.println("t = " + t);

            result = number / t;

            // t 가 0 일 경우 ArithmeticException / by zero 발생
            // 정수는 0으로 나누는 것이 금지되어있기 때문에 발생
            // 실수는 0으로 나누는 것은 금지되어 있지 않으며 예외가 발생하지 않는다.
            System.out.println("result = " + result);
        }
    }
}
