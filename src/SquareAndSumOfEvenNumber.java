import java.util.stream.IntStream;

public class SquareAndSumOfEvenNumber {
    public static void main(String[] args) {
        int squareSum = IntStream.rangeClosed(0, 10)
                .boxed()
                .filter(num -> num % 2 == 0)
                .map(num -> num * num)
                .reduce(0, Integer::sum);

        System.out.printf("Square and sum of even numbers :: %d%n", squareSum);
    }
}