import java.util.Scanner;

public class Solution220 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter the balance: ");
        final double balance = input.nextDouble();
        
        
        System.out.println("Enter the interest rate: ");
        final double annualInterestRate = input.nextDouble();
        
        final double interest = balance * (annualInterestRate / 1200);
        System.out.println("The interest is: " + interest);
    }
}