package standard.ch8;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * try-with-resources 문 - 자동 자원 반환 (JDK 1.7)
* 입출력(I/O)과 관련된 클래스를 사용할 때 유용
 */
public class TryWithResourceEx {
    public static void main(String[] args) {
        // try(), 괄호() 안에 객체를 생성하는 문자를 넣으면 이 객체는 따로 close()를 호출하지 않아도
        // try 블럭을 벗어나는 순간 자동적으로 close()가 호출된다. 그 다음 catch 블럭 또는 finally 블럭이 수행
        try (FileInputStream fis = new FileInputStream("score.dat");
             DataInputStream dis = new DataInputStream(fis);
        ) {
            int sum = 0;
            while (true) {
                int score = dis.readInt();
                System.out.println("score = " + score);
                sum += score;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
