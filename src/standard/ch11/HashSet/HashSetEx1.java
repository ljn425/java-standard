package standard.ch11.HashSet;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HashSetEx1 {
    public static void main(String[] args) {
        Object[] objArr = {"1", 1, "2", "2", "2", "3", "4", "4", "4"};

        Set<Object> set = new HashSet<>();

        for (int i = 0; i < objArr.length; i++) {
            set.add(objArr[i]);
        }

        /**
         * for 문 대신 1, 2 사용 가능
         */
//        Collections.addAll(set, objArr); // 1
//        set.addAll(Arrays.asList(objArr)); // 2

        /**
         * 배열과 `Set`을 한번에 선언과 초기화 하는 방법
         */
//        Set<Object> set = new HashSet<>(Arrays.asList(objArr));

        System.out.println(set);
    }
}
