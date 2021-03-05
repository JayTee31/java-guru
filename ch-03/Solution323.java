import java.util.Scanner;

public class Solution323 {
    public static void main(String[] args) {
        final double X_POINT_OF_THE_RECTANGLES_CENTER = 1;
        final double Y_POINT_OF_THE_RECTANGLES_CENTER = 1;
        final double RECTANGLES_WIDTH = 10;
        final double RECTANGLES_HEIGHT = 5;

        final Scanner input = new Scanner(System.in);

        System.out.println("Enter the point's 'x' coordinate");
        final double xCoordinate = input.nextDouble();

        System.out.println("Enter the point's 'y' coordinate");
        final double yCoordinate = input.nextDouble();

        final boolean horizontalDistance = (xCoordinate <= (X_POINT_OF_THE_RECTANGLES_CENTER + RECTANGLES_WIDTH / 2))
            && (xCoordinate >= (X_POINT_OF_THE_RECTANGLES_CENTER - RECTANGLES_WIDTH / 2)); 
        final boolean verticalDistance = (yCoordinate <= (Y_POINT_OF_THE_RECTANGLES_CENTER + RECTANGLES_HEIGHT / 2))
        && (yCoordinate >= (Y_POINT_OF_THE_RECTANGLES_CENTER - RECTANGLES_HEIGHT / 2));

        if (horizontalDistance && verticalDistance) {
            System.out.println("Point (" + xCoordinate + ", " + yCoordinate + ") is in the rectangle");
        } else {
            System.out.println("Point (" + xCoordinate + ", " + yCoordinate + ") is not in the rectangle");
        }
    }
}