package standard.ch8;

/**
 * catch 블럭
 */
public class ExceptionEx7 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try {
            System.out.println(3);
            System.out.println(0/0); //예외 발생
            System.out.println(4); //실행되지 않는다.
        } catch (ArithmeticException ae) {
            if (ae instanceof ArithmeticException)
                System.out.println("true");
            System.out.println("ArithmeticException = " + ae);
        //ArithmeticException 발생시 실행되지 않음, 다른 예외가 발생할 경우 실행됨    
        } catch (Exception e) {
            System.out.println("Exception = " + e);
        }
        System.out.println(6);
    }
}
