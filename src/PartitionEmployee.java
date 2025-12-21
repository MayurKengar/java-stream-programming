import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionEmployee {

    public static void main(String[] args) {
        var employees = List.of(
                new Employee(1, "Employee 1", "Engineering", 85000.0),
                new Employee(2, "Employee 2", "HR", 62000.0),
                new Employee(3, "Employee 3", "Sales", 71000.0),
                new Employee(4, "Employee 4", "Marketing", 69000.0),
                new Employee(5, "Employee 5", "Finance", 78000.0),
                new Employee(6, "Employee 6", "Engineering", 93000.0),
                new Employee(7, "Employee 7", "Sales", 73000.0),
                new Employee(8, "Employee 8", "HR", 60000.0),
                new Employee(9, "Employee 9", "Marketing", 67000.0),
                new Employee(10, "Employee 10", "Finance", 80000.0)
        );

        Map<Boolean, List<Employee>> result = employees.stream()
                .collect(Collectors.partitioningBy(
                        employee -> employee.salary() > 75000.0
                ));

        System.out.println(result);
    }
}
