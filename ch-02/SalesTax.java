import java.util.Scanner;

public class SalesTax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter purchase amount: ");
        double purchaseAmount = input.nextDouble();

        final double VAT = 0.27;
        double tax = purchaseAmount * VAT;
        double salesTax = (int)(tax * 100) / 100;
        System.out.println(tax);
        System.out.println(salesTax);
    }
}