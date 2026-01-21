import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class MethodReference {

    public static int getLength(String name) {
        return name.length();
    }

    public static void main(String[] args) {
        String name = "Java";
        //static reference
        ToIntFunction<String> func = MethodReference::getLength;
        System.out.println(func.applyAsInt(name));

        //Instance method reference
        Supplier<Integer> supplier = name::length;
        System.out.println(supplier.get());

        //Constructor reference
        Supplier<List<String>> methodRef = ArrayList::new;
        List<String> list = methodRef.get();
        list.add("Java");
        list.add("Spring");

        System.out.println(list);
    }
}
