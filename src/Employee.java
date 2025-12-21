public record Employee(int id, String name, String department, double salary) {

    @Override
    public String toString() {
        return  String.format(" id : %d Name : %s, salary : %.2f", id, name, salary);
    }
}
