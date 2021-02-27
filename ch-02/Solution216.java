import java.util.Scanner;

public class Solution216 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter the lenght of the side of a hexagon: ");
        final double lenght = input.nextDouble();

        final double area = 3 * Math.pow(3, 0.5) / 2 * Math.pow(lenght, 2);
        System.out.println("The area of the hexagon is: " + area);
    }
}