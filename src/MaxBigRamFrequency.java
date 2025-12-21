import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

public class MaxBigRamFrequency {
    public static void main(String[] args) {
        var sentence = "Java is great and java is fun. Java is powerful!";

        var result = Stream.of(sentence.toLowerCase()
                .replaceAll("[^a-z\\s]", "")
                .split(" "))
                .gather(Gatherers.windowSliding(2))
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()
                        )
                )
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow();

        System.out.println(result);
    }
}