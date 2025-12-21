import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindLongestWordFromFile {

    public static void main(String[] args) {
        var file = new File("paragraph.txt");

        /** Paragraph -
         * Yesterday, I went to the park near my house.
         * It was a beautiful sunny day, and many people were enjoying their time there.
         * I saw kids playing on the swings, couples walking hand in hand, and dogs running freely.
         * The air felt fresh and calm, making it a perfect place to relax and unwind.
         **/

        try (FileReader fileReader = new FileReader(file);) {
            var lines = fileReader.readAllLines();
            Map.Entry<String, Integer> entry = lines.stream()
                    .flatMap(line -> {
                        var newLine = line.replaceAll("[^a-zA-Z0-9\\s]", "")
                                .toLowerCase();
                        return Arrays.stream(newLine.split(" "));
                    })
                    .collect(
                            Collectors.toMap(
                                    Function.identity(),
                                    String::length,
                                    (existing, replacement) -> replacement,
                                    LinkedHashMap::new
                            )
                    ).entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue())
                    .get();
            System.out.println("Longest word from the paragraph is : " + entry.getKey());
        } catch (Exception exception) {
            System.out.println("IO Operation Failed...");
        }
    }
}
