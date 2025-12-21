
import module java.base;


// 3. Compact source files
void main() {
    var object = getSum(10, 20);

    // 1. Pattern matching can handle primitive data types for switch and instanceof statements.
    if (object instanceof int sum) {
        IO.println("The sum is " + sum);
    }

    // 2. Import module declarations
    var date = new Date();
    IO.println("Current Date " + date);
}

int getSum(int a, int b) {
    return a + b;
}