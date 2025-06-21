import java.util.*;

public class FinancialForecasting {

    public static double calculateFutureValue(double principal, double rate, int years) {
        // Base case
        if (years == 0) {
            return principal;
        }

        // Recursive call
        return calculateFutureValue(principal * (1 + rate), rate, years - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        // Input from user
        System.out.print("Enter the initial amount: ");
        double principal = scanner.nextDouble();
        
        System.out.print("Enter the annual growth rate (as a decimal): ");
        double rate = scanner.nextDouble();
        
        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        double futureValue = calculateFutureValue(principal, rate, years);
        System.out.printf("Future Value : %.2f%n", futureValue);

        scanner.close();
    }
}
