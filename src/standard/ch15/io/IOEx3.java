package standard.ch15.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx3 {
    public static void main(String[] args) {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;

        byte[] temp = new byte[4];

        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        System.out.println("input = " + Arrays.toString(inSrc));

        try {
            while (input.available() > 0) {
                int len = input.read(temp); //읽어 온 데이터의 개수를 반환한다.
                output.write(temp, 0, len); //읽어 온 만큼만 write 한다.

                outSrc = output.toByteArray();
                printArrays(temp, outSrc);
            }
        } catch (Exception e){
        }


    }

    private static void printArrays(byte[] temp, byte[] outSrc) {
        System.out.println("temp     = " + Arrays.toString(temp));
        System.out.println("output = " + Arrays.toString(outSrc));
    }

}
