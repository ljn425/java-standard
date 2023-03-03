package standard.ch14.lambda;

public class Outer {
    int val = 10;

    class Inner {
        int val = 20;

        void method(int i) {
            int val = 30;
            //i = 10;

            MyFunction f = () -> {
                System.out.println("i : " + i);
                System.out.println("val : " + val);
                System.out.println("Inner val = " + this.val);
                System.out.println("Outer val = " + Outer.this.val);
            };

            f.run();

        }
    }
}
