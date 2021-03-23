import java.util.Scanner;

public class Solution25 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter the subtotal: ");
        final double subtotal = input.nextDouble();
        
        System.out.println("Enter the gratuity rate: ");
        final double gratuityRate = input.nextDouble();
        
        final double gratuity = (int)((subtotal) * (gratuityRate / 100) * 10) / 10.0;
        final double total = (int)((subtotal) * (1 + (gratuityRate / 100)) * 10) / 10.0;
        
        System.out.println("The gratuity is " + gratuity
            + "$" + " and the total is " + total + "$");
    }
}