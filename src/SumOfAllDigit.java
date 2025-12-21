import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumOfAllDigit {

    public static void main(String[] args) {
        int number = 1234456522;

        Integer sum = Stream.of(String.valueOf(number)
                        .split(""))
                .collect(
                        Collectors.summingInt(Integer::parseInt)
                );
        System.out.printf("Sum of given number is %d", sum);
    }
}
