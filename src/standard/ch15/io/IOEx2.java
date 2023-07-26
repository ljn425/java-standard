package standard.ch15.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx2 {
    public static void main(String[] args) {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;

        byte[] temp = new byte[10];

        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        input.read(temp, 0, temp.length);  // 읽어 온 데이터를 배열 temp 에 담는다.
        output.write(temp, 5, 5);

        outSrc = output.toByteArray();

        System.out.println("Arrays.toString(inSrc) = " + Arrays.toString(inSrc));
        System.out.println("Arrays.toString(temp) = " + Arrays.toString(temp));
        System.out.println("Arrays.toString(outSrc) = " + Arrays.toString(outSrc));
    }
}
