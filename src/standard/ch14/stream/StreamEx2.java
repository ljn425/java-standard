package standard.ch14.stream;

import java.io.File;
import java.util.stream.Stream;

public class StreamEx2 {
    public static void main(String[] args) {
        File[] fileArr = {
                new File("EX1.java"),
                new File("EX1.bak"),
                new File("EX2.java"),
                new File("EX1"),
                new File("EX1.txt"),
        };

        Stream<File> fileStream = Stream.of(fileArr);
        
        // map()으로 Stream<File>을 Stream<String>으로 변환
        Stream<String> fileNameStream = fileStream.map(File::getName);
        fileNameStream.forEach(System.out::println); // 모든 파일의 이름을 출력

        fileStream = Stream.of(fileArr);// 스트림을 다시 생성

        fileStream.map(File::getName)
                .filter(s -> s.indexOf('.') != -1) // 확장자가 없는 것은 제외
                .map(s -> s.substring(s.indexOf('.')+1)) // 확장자만 추출
                .map(String::toUpperCase) // 모두 대문자로 변환
                .distinct() // 중복 제거
                .forEach(System.out::println);


    }
}
