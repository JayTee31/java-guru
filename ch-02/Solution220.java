import java.util.Scanner;

public class Solution220 {
    public static void main(String[] args) {
        final double MONTHLY_INTEREST_RATE = 1200
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter the balance: ");
        final double balance = input.nextDouble();
        
        
        System.out.println("Enter the interest rate: ");
        final double annualInterestRate = input.nextDouble();
        
        final double interest = balance * (annualInterestRate / MONTHLY_INTEREST_RATE);
        System.out.println("The interest is: " + interest);
    }
}