import java.util.Arrays;

public class CountBinaryNumber {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 0, 1, 1, 1, 0};
        System.out.printf("Total count of binary number 1 occurrence is :: %d",
                Arrays.stream(arr).sum());
    }
}