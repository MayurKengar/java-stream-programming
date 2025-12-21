import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumOfSquareEvenOdd {
    public static void main(String[] args) {
        IntStream.rangeClosed(0, 10)
                .boxed()
                .collect(
                        Collectors.partitioningBy(
                                num -> num % 2 == 0,
                                Collectors.summingInt(num -> num * num)
                        )
                )
                .forEach((key, sum) -> System.out.printf("The sum of the squares of %s is %d%n",
                        key ? "Even number" : "Odd number", sum));

        /**
         * OUTPUT Logic:
         * - The `partitioningBy` collector returns a Map<Boolean, Integer>,
         *   where the Boolean key represents the result of the predicate (true for even, false for odd).

         * - Even numbers: 2, 4, 6, 8, 10
         *   Sum of squares (using summingInt): 4 + 16 + 36 + 64 + 100 = 220

         * - Odd numbers: 1, 3, 5, 7, 9
         *   Sum of squares (using summingInt): 1 + 9 + 25 + 49 + 81 = 165
         */

    }
}
