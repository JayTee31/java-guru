import java.util.Scanner;

public class Solution215 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        
        System.out.println("Enter x1:");
        final double x1 = input.nextDouble();
        
        System.out.println("Enter y1:");
        final double y1 = input.nextDouble();
        
        System.out.println("Enter x2:");
        final double x2 = input.nextDouble();
        
        System.out.println("Enter y2:");
        final double y2 = input.nextDouble();

        
        final double distance = Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5);
        System.out.println("The distance between the two points is: " + distance);
    }
}