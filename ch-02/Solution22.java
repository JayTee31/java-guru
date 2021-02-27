import java.util.Scanner;

public class Solution22 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter the lenght of sides of an equilateral triangle (to get the area): ");
        final double lenghtOfSides = input.nextDouble();
        final double area = Math.pow(3, 0.5) / 4 * Math.pow(lenghtOfSides, 2);
        
        System.out.println("Enter the height of an equilateral triangle based prism (to get the volume): ");
        final double heightOfPrism = input.nextDouble();
        final double volume = area * heightOfPrism;
        
        System.out.println("The area of the triangle is: " + area + "\n"
            + "The volume of the prism is: " + volume);
    }
}
