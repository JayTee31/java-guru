import java.util.Scanner;

public class Solution22 {
    public static void main(String[] args) {
        final double SQRT_THREE_DIVIDED_BY_FOUR = Math.pow(3, 0.5) / 4;
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter the lenght of sides of an equilateral triangle (to get the area): ");
        final double lengthOfSides = input.nextDouble();
        
        System.out.println("Enter the height of an equilateral triangle based prism (to get the volume): ");
        final double heightOfPrism = input.nextDouble();
        
        final double area = SQRT_THREE_DIVIDED_BY_FOUR * Math.pow(lengthOfSides, 2);
        final double volume = area * heightOfPrism;

        System.out.println("The area of the triangle is: " + area + "\n"
            + "The volume of the prism is: " + volume);
    }
}
