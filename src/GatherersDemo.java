import java.util.List;
import java.util.stream.Gatherers;

public class GatherersDemo {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                .gather(Gatherers.fold(() -> "", (str, num) -> str + num))
                .forEach(System.out::println);
    }
}
