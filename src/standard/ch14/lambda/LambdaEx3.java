package standard.ch14.lambda;

public class LambdaEx3 {

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.method(100);

    }
}
