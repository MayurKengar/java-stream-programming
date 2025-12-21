import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ShuffleSentence {

    public static void main(String[] args) {
        var sentence = "I love java programming language.";

        var words = Arrays.asList(sentence.split(" "));
        Collections.shuffle(words);
        System.out.println("Using collections shuffle method :: " + String.join(" ", words));

        var shuffle = Arrays.stream(sentence.split(" "))
                .sorted(Comparator.comparingDouble(a -> Math.random()))
                .collect(Collectors.joining(" "));
        System.out.println("Using stream sort method :: " + shuffle);

        /**
         * OUTPUT -
         * Using collections shuffle method :: language. I love programming java
         * Using stream sort method :: java programming language. love I
         
         * Note - output will be random on each execution
         **/
    }
}
