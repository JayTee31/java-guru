import java.util.Scanner;

public class ComputeLoan {
    public static void main(String[] args) {
        final int NUMBER_OF_MONTHS_PER_YEAR = 12;
        
        final Scanner input = new Scanner(System.in);
        System.out.println("Annual interest rate(%): ");
        final double interestRate = input.nextDouble();

        System.out.println("Loan amount: ");
        final int loanAmount = input.nextInt();

        System.out.println("Number of years: ");
        final int numberOfYears = input.nextInt();

        
        final double monthlyInterestRate = interestRate / (NUMBER_OF_MONTHS_PER_YEAR * 100);
        System.out.println("Monthly interest Rate: " + monthlyInterestRate);
        
        final double monthlyPaymentNumerator = loanAmount * monthlyInterestRate;
        final double monthlyPaymentMinorDenominator = Math.pow(1 + monthlyInterestRate, numberOfYears * NUMBER_OF_MONTHS_PER_YEAR);
        final double monthlyPaymentDenominator = 1 - 1 / monthlyPaymentMinorDenominator;
        
        final double monthlyPayment = monthlyPaymentNumerator / monthlyPaymentDenominator;
        final double monthlyPaymentTwoDecimal = (int)(monthlyPayment * 100) / 100.0;
        System.out.println("Monthly Payment: " + monthlyPaymentTwoDecimal);
        
        
        final double totalPayment = monthlyPayment * numberOfYears * NUMBER_OF_MONTHS_PER_YEAR;
        final double totalPaymentTwoDecimal = (int)(totalPayment * 100) / 100.0;
        System.out.println("Total Payment: " + totalPaymentTwoDecimal);
    }
}