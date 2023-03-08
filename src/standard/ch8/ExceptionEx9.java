package standard.ch8;

public class ExceptionEx9 {
    public static void main(String[] args) {
        try {
            throw new Exception("고의적으로 발생");
        } catch (Exception e) {
            System.out.println("에러 메시지: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("프로그램 종료");
    }
}
