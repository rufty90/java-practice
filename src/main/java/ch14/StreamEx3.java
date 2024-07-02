package ch14;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx3 {
    public static void main(String[] args) {
        Student[] students = {
                new Student("이", 3, 300),
                new Student("kim", 1, 200),
                new Student("oan", 2, 100),
                new Student("park", 2, 150),
                new Student("so", 1, 200),
                new Student("na", 3, 290),
                new Student("gam", 3, 180)
        };

        Stream<Student> stream = Stream.of(students);

        stream.sorted(Comparator.comparing(Student::getBan)
                .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);

        stream = Stream.of(students);
        IntStream scoreStream = stream.mapToInt(Student::getTotalScore);

        IntSummaryStatistics stat = scoreStream.summaryStatistics();
        System.out.println("count= " + stat.getCount());
        System.out.println("sum= " + stat.getSum());
        System.out.printf("average= %.2f%n", stat.getAverage());
        System.out.println("min = "+ stat.getMin());
        System.out.println("max = "+ stat.getMax());
    }
}
