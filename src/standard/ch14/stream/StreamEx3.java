package standard.ch14.stream;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx3 {
    public static void main(String[] args) {
        Student[] stuArr= {
                new Student("이자바", 3, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 2, 100),
                new Student("박자바", 2, 150),
                new Student("소자바", 1, 200),
                new Student("나자바", 3, 290),
                new Student("감자바", 3, 180)
        };

        Stream<Student> subStream = Stream.of(stuArr);

        subStream.sorted(Comparator.comparing(Student::getBan)
                        .thenComparing(Comparator.naturalOrder()))
                        .forEach(System.out::println);
        
        subStream = Stream.of(stuArr);
        IntStream stuScoreStream = subStream.mapToInt(Student::getTotalScore);

        IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
        System.out.println("stat.getCount() = " + stat.getCount());
        System.out.println("stat.getSum() = " + stat.getSum());
        System.out.println("stat.getAverage() = " + stat.getAverage());
        System.out.println("stat.getMin() = " + stat.getMin());
        System.out.println("stat.getMax() = " + stat.getMax());

    }

    static class Student implements Comparable<Student> {
        String name;
        int ban;
        int totalScore;

        public Student(String name, int ban, int totalScore) {
            this.name = name;
            this.ban = ban;
            this.totalScore = totalScore;
        }

        @Override
        public String toString() {
            return String.format("[%s, %d, %d]", name, ban, totalScore).toString();
        }

        public String getName() {
            return name;
        }

        public int getBan() {
            return ban;
        }

        public int getTotalScore() {
            return totalScore;
        }

        // 총점 내림차순을 기본 정렬로 한다.
        @Override
        public int compareTo(Student s) {
            return s.totalScore - this.totalScore;
        }
    }
}
