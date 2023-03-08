package standard.ch8;

/**
 * try 내에 예외 발생시 다음 로직이 수행되지 않는다.
 */
public class ExceptionEx5 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try {
            System.out.println(3);
            System.out.println(0/0); //예외 발생
            System.out.println(4); //실행되지 않는다.
        } catch (ArithmeticException ae) {
            System.out.println(5);
        }
        System.out.println(6);
    }
}
