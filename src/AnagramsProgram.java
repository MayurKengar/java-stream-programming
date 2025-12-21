import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnagramsProgram {

    public static void main(String[] args) {
        System.out.println(findAnagrams("CarRace", "RaceCar"));
        System.out.println(findAnagrams("BatRat", "CatRat"));
    }

    private static String findAnagrams(String first, String second) {
        var firstJoined = Stream.of(first.replaceAll("\\s+", "").split(""))
                .sorted()
                .map(String::toLowerCase)
                .collect(Collectors.joining());

        var secondJoined = Stream.of(second.replaceAll("\\s+", "").split(""))
                .sorted()
                .map(String::toLowerCase)
                .collect(Collectors.joining());

        return firstJoined.equals(secondJoined) ? String.format("Given strings %s and %s are anagrams",
                first, second) : String.format("Given strings %s and %s are non anagrams", first, second);
    }
    /**
     * OUTPUT
     * Given strings CarRace and RaceCar are anagrams
     * Given strings BatRat and CatRat are non anagrams
     * */
}
