import java.util.List;

public class FindDigitString {

    public static void main(String[] args) {
        List<String> names = List.of("5java", "python", "3C", "C++", "1Ruby");

        List<String> filteredNames = names.stream()
                .filter(name -> Character.isDigit(name.charAt(0)))
                .toList();

        System.out.println(filteredNames);
    }
}
