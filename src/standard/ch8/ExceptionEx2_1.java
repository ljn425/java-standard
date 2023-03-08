package standard.ch8;

/**
 * 실수를 0으로 나누는 예제
 */
public class ExceptionEx2_1 {
    public static void main(String[] args) {
        Double realNumber = 15.5;
        double result = realNumber / 0;

        // 실수를 0으로 나누면 Infinity 즉 무한대가 나온다.
        System.out.println("result = " + result);


    }
}
