import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class MaxSalary {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
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

        Map<String, Employee> result = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Employee::salary)),
                                emp -> emp.orElse(null)
                        )
                ));

        for (Map.Entry<String, Employee> entry : result.entrySet()) {
            System.out.println("Department :: " + entry.getKey());
            System.out.println("Max paid Employee :: " + entry.getValue() + "\n");
        }

        /**
         * Department :: Engineering
         * Max paid Employee ::  id : 6 Name : Employee 6, salary : 93000.00
         * Department :: Sales
         * Max paid Employee ::  id : 7 Name : Employee 7, salary : 73000.00
         * Department :: Finance
         * Max paid Employee ::  id : 10 Name : Employee 10, salary : 80000.00
         * Department :: HR
         * Max paid Employee ::  id : 2 Name : Employee 2, salary : 62000.00
         * Department :: Marketing
         * Max paid Employee ::  id : 4 Name : Employee 4, salary : 69000.00
         * */
    }
}
