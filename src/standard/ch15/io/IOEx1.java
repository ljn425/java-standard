package standard.ch15.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx1 {
    public static void main(String[] args) {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;

        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int data = 0;

        while((data = input.read()) != -1) {
            System.out.println("data : " + data);
            output.write(data);
        }

        outSrc = output.toByteArray();  // 스트림의 내용을 byte 배열로 반환한다.

        System.out.println("input = " + Arrays.toString(inSrc));
        System.out.println("output = " + Arrays.toString(outSrc));
    }
}
