void main() {
    try {
        var employeeDto = new EmployeeDto("Java", "Software Developer", 30, 30000D);
        System.out.println(employeeDto);
        System.out.println(employeeDto.name());

    } catch (IllegalArgumentException exception) {
        System.out.println(exception.getLocalizedMessage());
    }
}

record EmployeeDto(String name,
                   String department,
                   Integer age,
                   Double salary) {
    public EmployeeDto {
        if (age <= 18)
            throw new IllegalArgumentException("Age should be grater than 18");
    }
}