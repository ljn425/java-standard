package standard.ch14.optional;

import java.util.Optional;
import java.util.OptionalInt;

public class OptionalEx1 {
    public static void main(String[] args) {
        Optional<String> optStr = Optional.of("abcde");
        Optional<Integer> optInt = optStr.map(String::length);
        System.out.println("optStr.get() = " + optStr.get());
        System.out.println("optInt.get() = " + optInt.get());

        Integer result = Optional.of("11")
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt)
                .get();

        Integer result2 = Optional.of("")
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt)
                .orElse(-1);

        System.out.println("result = " + result);
        System.out.println("result2 = " + result2);

        Optional.of("1515")
                .map(Integer::parseInt)
                .ifPresent(x -> System.out.printf("result3 = %d%n", x));

        OptionalInt optionalInt1 = OptionalInt.of(0);
        OptionalInt optionalInt2 = OptionalInt.empty();

        System.out.println("optionalInt1 = " + optionalInt1.isPresent());
        System.out.println("optionalInt2 = " + optionalInt2.isPresent());

        Optional<Object> opt = Optional.ofNullable(null);
        Optional<Object> opt2 = Optional.empty();
        System.out.println("opt = " + opt);
        System.out.println("opt2 = " + opt2);
        System.out.println("opt.equals(opt2) = " + opt.equals(opt2));

        int result3 = optStrToInt(Optional.ofNullable("123"), 0);
        int result4 = optStrToInt(Optional.ofNullable(""), 0);

        System.out.println("result3 = " + result3);
        System.out.println("result4 = " + result4);

        int result5 = optStrToInt(Optional.ofNullable("123"), -1);
        int result6 = optStrToInt(Optional.ofNullable(""), -1);

        System.out.println("result5 = " + result5);
        System.out.println("result6 = " + result6);
    }

    static int optStrToInt(Optional<String> optStr, int defaultValue) {
        try {
            return optStr.map(Integer::parseInt).orElse(-1);
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
