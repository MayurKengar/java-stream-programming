import java.util.stream.Collectors;

public class SwapCaseProgram {

    public static void main(String[] args) {
        String string = "sTriNG";

        String swapCase = string.chars()
                .mapToObj(ch -> (char) ch)
                .map(SwapCaseProgram::swapCase)
                .collect(Collectors.joining());

        System.out.println(swapCase);
    }

    private static String swapCase(char ch) {
        char result = Character.isLowerCase(ch) ? Character.toUpperCase(ch) :
                Character.toLowerCase(ch);
        return Character.toString(result);
    }
}
