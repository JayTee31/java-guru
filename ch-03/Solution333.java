import java.util.Scanner;

public class Solution333 {
    public static void main(String[] args) {
        final double EPSILON = 0.00000001;
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter the weight of the first package");
        final double weightOfFirstPackage = input.nextDouble();
        
        System.out.println("Enter the price of the first package");
        final double priceOfFirstPackage = input.nextDouble();
        
        System.out.println("Enter the weight of the second package");
        final double weightOfSecondPackage = input.nextDouble();
        
        System.out.println("Enter the price of the second package");
        final double priceOfSecondPackage = input.nextDouble();

        final double pricePerWeight1 = priceOfFirstPackage / weightOfFirstPackage;
        final double pricePerWeight2 = priceOfSecondPackage / weightOfSecondPackage;
        final boolean isTheTwoRiceHasTheSamePrice = Math.abs(pricePerWeight1 - pricePerWeight2) < EPSILON;

        if (isTheTwoRiceHasTheSamePrice) {
            System.out.println("The two packages have the same price.");
        } else if (pricePerWeight1 > pricePerWeight2) {
            System.out.println("The second package has the better price.");
        } else {
            System.out.println("The first package has the better price.");
        }
    }
}