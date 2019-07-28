public class CodiblyCalculator {
    public static void main(String[] args) {

        Integer calculated = StackCalculator.calculateByStack(args);
        if (calculated != null) {
            System.out.println("Calculation result:");
            System.out.println(calculated);
        } else {
            System.out.println("Invalid expression");
        }
    }

}
