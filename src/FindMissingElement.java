import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class FindMissingElement {

    void main() {
        var elements = List.of(1, 2, 2, 5, 5, 5, 5, 7, 7, 8, 9);

        var uniqueElements = new HashSet<>(elements);

        var missingElements = IntStream.rangeClosed(1, 9)
                .boxed()
                .filter(elem -> !uniqueElements.contains(elem))
                .toList();

        System.out.println("Missing elements from the list is :: " + missingElements);
    }
}
