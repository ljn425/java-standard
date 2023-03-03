package standard.ch14.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LambdaEx4 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<10; i++)
            list.add(i);

        // list 의 모든 요소를 출력
        list.forEach(i -> System.out.print(i+", "));
        System.out.println();

        // list 에서 2 또는 3의 배수를 제거한다.
        list.removeIf(i -> i % 2 == 0 || i % 3 == 0);
        System.out.println("list = " + list);

        // list 의 각 요소에 10을 곱한다.
        list.replaceAll(i -> i * 10);
        System.out.println("list = " + list);

        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");

        // map 의 모든 요소를 (k, v) 의 형식으로 출력한다.
        map.forEach((k, v) -> System.out.println("k = " + k + " v = " + v));
        System.out.println();
    }
}
