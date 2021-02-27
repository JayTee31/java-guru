import java.util.Scanner;

public class Solution223 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter the driving distance:");
        final double distanceInMiles = input.nextDouble();
        
        System.out.println("Enter miles per gallon:");
        final double milesPerGallon = input.nextDouble();

        System.out.println("Enter price per gallon:");
        final double PricePerGallon = input.nextDouble();
        
        final double cost = (int)(distanceInMiles / milesPerGallon * PricePerGallon * 100) / 100.0;
        System.out.println("The cost of driving is: " + "$" + cost);
    }
}