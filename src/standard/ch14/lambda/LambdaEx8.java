package standard.ch14.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaEx8 {
    public static void main(String[] args) {
        Function<String, Integer> f = (String s)-> Integer.parseInt(s);
        Function<String, Integer> f2 = Integer::parseInt;
        System.out.println("f2 = " + f2.apply("17"));
        
        BiFunction<String, String, Boolean> bf = (s, s1) -> s.equals(s1);
        BiFunction<String, String, Boolean> bf2 = String::equals;
        System.out.println("bf2 = " + bf2.apply("A", "B"));

        // 인스턴스메서드 참조, 참조변수::method
        TestClass obj = new TestClass();
        Function<String, Boolean> objF = x -> obj.equals(x);
        Function<String, Boolean> objF2 = obj::equals;

        // static 메서드 참조, ClassName::method
        Function<String, Boolean> objF3 = TestClass::isString;
        System.out.println("objF3 = " + objF3.apply("ABC"));

        Function<String, Integer> objF4 = TestClass::getId;
        System.out.println("objF4 = " + objF4.apply("123"));

        // 생성자의 메서드 참조
        Supplier<TestClass> s = () -> new TestClass();
        Supplier<TestClass> s1 = TestClass::new;

        // 매개변수 있는 생성자
        Function<Integer, TestClass> nF = i -> new TestClass(i);
        Function<Integer, TestClass> nF2 = TestClass::new;

        BiFunction<Integer, String, TestClass> nF3 = (i, t) -> new TestClass(i, t);
        BiFunction<Integer, String, TestClass> nF4 = TestClass::new;

        // 배열 생성
        Function<Integer, int[]> aF = i -> new int[i];
        Function<Integer, int[]> aF2 = int[]::new;

    }

    static class TestClass {

        public TestClass(){}
        public TestClass(int i){}
        public TestClass(int i, String s) {}

        static Boolean isString(String s) {
            return s.equals("ABC");
        }

        static int getId(String s) {
            return Integer.parseInt(s);
        }
    }

}

