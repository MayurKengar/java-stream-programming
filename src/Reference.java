public class Reference {

    public static int printStatic(String name) {
        return name.length();
    }

    public void printInstance() {
        System.out.println("Instance method Reference...");
    }

    public Reference() {
        System.out.println("Constructor Reference");
    }
}
