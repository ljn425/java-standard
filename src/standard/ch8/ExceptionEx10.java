package standard.ch8;

public class ExceptionEx10 {
    public static void main(String[] args) {
//        throw new Exception(); checked Exception, try 문이나 throw 하지 않으면 컴파일 에러 발생
        throw new RuntimeException(); // unchecked Exception, 컴파일 에러가 발생하지 않지만 실행시 예외 발생
    }
}
