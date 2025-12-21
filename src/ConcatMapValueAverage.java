import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcatMapValueAverage {

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

        var averageMap = Stream.concat(mapOne.entrySet().stream(), mapTwo.entrySet().stream())
                .collect(
                        Collectors.groupingBy(
                                Map.Entry::getKey,
                                Collectors.averagingDouble(Map.Entry::getValue)
                        )
                );

        System.out.println("Final Map with average values :: " + averageMap);

        //OUTPUT - Final Map with average values :: {Maths=80.0, Chemistry=60.0, Biology=74.0, History=80.0, Physics=65.0}
    }
}
