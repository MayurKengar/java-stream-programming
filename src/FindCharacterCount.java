import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindCharacterCount {

    public static void main(String[] args) {
        String str = "Java is a great programming language!";

        Map<Character, Long> charCount = str
                .chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        System.out.println(charCount);
    }
}
