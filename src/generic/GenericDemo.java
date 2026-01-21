package generic;

public class GenericDemo {
    public static void main(String[] args) {
        Box<Integer> box = new Box<>();
        box.set(10);
        System.out.println(box.get());
    }
}
