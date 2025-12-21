import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Gatherers;
import java.util.stream.IntStream;

public class GatherersWindowFixedDemo {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int batchSize = 5;

        //Normal stream approach for creating batch
        List<List<Integer>> streamBatch = IntStream.range(0, numbers.size())
                .boxed()
                .collect(Collectors.groupingBy(num -> num / batchSize))
                .values()
                .stream()
                .map(iterator -> iterator.stream().map(numbers::get).toList())
                .toList();

        System.out.println("Stream approach :: " + streamBatch);

        //Gatherers using window fixed approach for creating batch
        List<List<Integer>> windowFixedBatch = numbers.stream()
                .gather(Gatherers.windowFixed(batchSize))
                .toList();

        System.out.println("Gatherers approach :: " + windowFixedBatch);
    }
}
