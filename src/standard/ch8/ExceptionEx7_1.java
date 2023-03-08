package standard.ch8;

/**
 * catch 블럭 | 사용
 */
public class ExceptionEx7_1 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try {
            System.out.println(3);
            System.out.println(0/0); //예외 발생
            System.out.println(4); //실행되지 않는다.
        //JDK1.7부터 | 기호 사용으로 멀티 체크 가능
        } catch (ArithmeticException | NullPointerException e){
            if (e instanceof ArithmeticException)
                System.out.println("ArithmeticException");
            System.out.println("Exception = " + e.getMessage());
        }
        System.out.println(6);
    }
}
