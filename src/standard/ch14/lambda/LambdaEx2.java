package standard.ch14.lambda;

public class LambdaEx2 {
    public static void main(String[] args) {
        MyFunction f = () -> {};
        String str = ( (Object) f ).toString();

        System.out.println(str);
    }
}
