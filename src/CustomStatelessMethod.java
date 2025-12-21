import java.util.List;
import java.util.stream.Gatherer;

public class CustomStatelessMethod {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("Normal Stream Approach :: ");
        numbers.stream()
                .filter(element -> element % 2 == 0)
                .map(element -> element * element)
                .forEach(System.out::println);

        System.out.println("Gatherer Approach :: ");
        numbers.stream()
                .gather(Gatherer.of(new CustomGatherer()))
                .forEach(System.out::println);
    }

    //We can use this custom logic anywhere if required.
    private static class CustomGatherer implements Gatherer.Integrator<Void, Integer, Integer> {

        @Override
        public boolean integrate(Void state, Integer element, Gatherer.Downstream<? super Integer> downstream) {
            if(element % 2 == 0)
                downstream.push(element * element);
            return true;
        }
    }
}
