package ch14;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamEx4 {
    public static void main(String[] args) {
        Stream<String []> stream = Stream.of(
                new String[] { "abc", "def", "jdk"},
                new String[] { "ABC", "GEF", "JDK"}
        );

        Stream<String> stringStream = stream.flatMap(Arrays::stream);

        stringStream.map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::print);
        System.out.println();

        String[] lineArr = {
                "Believe or not It is true",
                "Do or do not There is no try"
        };

        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(line -> Stream.of(line.split(" +")))
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::print);
        System.out.println();

        Stream<String> strStream1 = Stream.of("AAA", "ABC", "bDE", "DE");
        Stream<String> strStream2 = Stream.of("bbb", "AAA", "ccc", "dd");

        Stream<Stream<String>> streamStream = Stream.of(strStream1, strStream2);
        Stream<String> strStreStre = streamStream
                .map(s -> s.toArray(String[]::new))
                .flatMap(Arrays::stream);

        strStreStre.map(String::toLowerCase)
                .distinct()
                .forEach(System.out::println);
    }
}
