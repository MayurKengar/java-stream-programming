import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindUniqueOccurrence {

    public static void main(String[] args) {
        String str = "Good Morning";

        Map<Character, Long> characterLongMap = str.chars()
                .mapToObj(ch -> (char) ch)
                .map(Character::toLowerCase)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        Map.Entry<Character, Long> uniqueChar = characterLongMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .get();

        System.out.println("First unique character from the given string is : " + uniqueChar.getKey());
    }
}
