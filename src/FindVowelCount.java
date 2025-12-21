import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindVowelCount {

    public static void main(String[] args) {
        // Given a list of words
        List<String> words = Arrays.asList("pen", "pencil", "paper", "cutter", "random");

        Map<String, Long> vowelCount = words.stream()
                .collect(
                        Collectors.toMap(
                                Function.identity(),
                                word -> word.chars()
                                        .mapToObj(ch -> (char) ch)
                                        .filter(ch -> "aeiouAEIOU".indexOf(ch) != -1)
                                        .count()
                        )
                );
        System.out.println(vowelCount);
    }
}
