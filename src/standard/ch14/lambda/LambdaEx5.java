package standard.ch14.lambda;

import javax.lang.model.SourceVersion;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class LambdaEx5 {
    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int) (Math.random()*100) + 1;
        Consumer<Integer> c = i -> System.out.print(i+", ");
        Predicate<Integer> p = i -> i%2==0;
        Function<Integer, Integer> f = i -> i/10*10;

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);
        System.out.println("list = " + list);

        printEvenNum(p, c, list);

        List<Integer> newList = doSomething(f, list);
        System.out.println("newList = " + newList);
    }

    private static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
        List<T> newList = new ArrayList<>(list.size());

        for (T t : list) {
            newList.add(f.apply(t));
        }

        return newList;
    }

    private static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for (T i : list) {
            if(p.test(i)) {
                c.accept(i);
            }
        }
        System.out.println("]");
    }

    private static void makeRandomList(Supplier<Integer> s, List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(s.get());
        }
    }
}
