import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcatMap {
    public static void main(String[] args) {
        var mapOne = Map.of(
                "Physics", 70,
                "Chemistry", 65,
                "Maths", 90,
                "Biology", 58
        );

        var mapTwo = Map.of(
                "Physics", 60,
                "Chemistry", 55,
                "Maths", 70,
                "Biology", 90,
                "History", 80
        );

        var streamConcat = Stream.concat(mapOne.entrySet().stream(), mapTwo.entrySet().stream())
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                Integer::sum,
                                HashMap::new
                        )
                );

        System.out.println("Final Map Using Stream Concat :: " + streamConcat);

        var streamOf = Stream.of(mapOne, mapTwo)
                .flatMap(map -> map.entrySet().stream())
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                Integer::sum,
                                HashMap::new
                        )
                );
        System.out.println("Final Map Using Stream Of :: " + streamOf);

        /**
         * OUTPUT
         * Final Map Using Stream Concat :: {Maths=160, Chemistry=120, Biology=148, History=80, Physics=130}
         * Final Map Using Stream Of :: {Maths=160, Chemistry=120, Biology=148, History=80, Physics=130}
         * */
    }
}
