import java.util.Scanner;

public class Solution423 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter employee's name:");
        final String employeeName = input.nextLine();

        System.out.println("Enter number of hours worked in a week:");
        final double hoursWorked = input.nextDouble();

        System.out.println("Enter hourly pay rate:");
        final double hourlyPayRate = input.nextDouble();

        System.out.println("Enter federal tax withholding rate:");
        final double federalTax = input.nextDouble();

        System.out.println("Enter state tax withholding rate:");
        final double stateTax = input.nextDouble();

        final double grossPay = hourlyPayRate * hoursWorked;
        final double federalWithholding = grossPay * federalTax;
        final double stateWithholding = grossPay * stateTax;
        final double totalDeduction = federalWithholding + stateWithholding;
        final double netPay = grossPay - totalDeduction;


        System.out.printf("Employee's Name: %s\nHours Worked: %.1f\nPay Rate: $%.2f\n" +
                "Gross Pay: $%.2f\nDeductions:\n\tFederal Withholding (%.1f%%): $%.1f\n\t" +
                "State Withholding: (%.1f%%): $%.2f\n\tTotal Deduction: $%.2f\nNet Pay: $%.2f",
                employeeName, hoursWorked, hourlyPayRate, grossPay, federalTax * 100, federalWithholding,
                stateTax * 100, stateWithholding, totalDeduction, netPay);
    }
}
