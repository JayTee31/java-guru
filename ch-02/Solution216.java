import java.util.Scanner;

public class Solution216 {
    public static void main(String[] args) {
        final double SQRT_THREE = Math.pow(3, 0.5);
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter the length of the side of a hexagon: ");
        final double lenght = input.nextDouble();

        final double area = 3 * SQRT_THREE / 2 * Math.pow(lenght, 2);
        System.out.println("The area of the hexagon is: " + area);
    }
}