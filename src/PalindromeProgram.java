import java.util.stream.IntStream;

public class PalindromeProgram {
    public static void main(String[] args) {
        var word = "Madam";
        System.out.printf("Given word - %s is %s%n" , word, isPalindrome(word) ? " Palindrome" :
                " Non Palindrome");
        // Given word - Madam is Palindrome

        word = "Rabbit";
        System.out.printf("Given word - %s is %s%n" , word, isPalindrome(word) ? " Palindrome" :
                " Non Palindrome");
        // Given word - Rabbit is Non Palindrome
    }

    private static boolean isPalindrome(String word) {
        if(word.isBlank())
            return false;

        var parsed = word.trim()
                .toLowerCase();
        var length = parsed.length();

        return IntStream.range(0, length / 2)
                .noneMatch(idx -> parsed.charAt(idx) != parsed.charAt(length - idx - 1));
    }
}
