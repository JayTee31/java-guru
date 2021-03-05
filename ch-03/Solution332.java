import java.util.Scanner;

public class Solution332 {
    public static void main (String[] args) {
        final double EPSILON = 0.00000001;
        final Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the x and y cordinates of p0 (in that order)");
        final double p0x0 = input.nextDouble();
        final double p0y0 = input.nextDouble();

        System.out.println("Enter the x and y cordinates of p1 (in that order)");
        final double p1x1 = input.nextDouble();
        final double p1y1 = input.nextDouble();

        System.out.println("Enter the x and y cordinates of p2 (in that order)");
        final double p2x2 = input.nextDouble();
        final double p2y2 = input.nextDouble();

        final double calculation = (p1x1 - p0x0) * (p2y2 - p0y0) - (p2x2 - p0x0) * (p1y1 - p0y0);
        final boolean isTheCalculationZero = Math.abs(calculation) < EPSILON;

        if (isTheCalculationZero) {
            System.out.println("P2 is on the line");
        } else if (calculation < 0) {
            System.out.println("P2 is on the right side of the line");
        } else {
            System.out.println("P2 is on the left side of the line");
        }
    }
}