import java.util.Scanner;

public class Solution328 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter r1's center x-, y-coordinates, width and height (in that order)");
        final double r1x1 = input.nextDouble();
        final double r1y1 = input.nextDouble();
        final double r1width = input.nextDouble();
        final double r1height = input.nextDouble();
        
        System.out.println("Enter r2's center x-, y-coordinates, width and height (in that order)");
        final double r2x2 = input.nextDouble();
        final double r2y2 = input.nextDouble();
        final double r2width = input.nextDouble();
        final double r2height = input.nextDouble();

        final boolean r2WidthDistanceNegativeSide = (r2x2 - r2width / 2 >= r1x1 - r1width / 2);
        final boolean r2WidthDistancePositiveSide = (r2x2 + r2width / 2 <= r1x1 + r1width / 2);
        final boolean r2HeightDistanceNegativeSide = (r2y2 - r2height / 2 >= r1y1 - r1height / 2);
        final boolean r2HeightDistancePositiveSide = (r2y2 + r2height / 2 <= r1y1 + r1height / 2);
        final boolean horizontalr2InsideOfr1 = r2WidthDistanceNegativeSide && r2WidthDistancePositiveSide;
        final boolean verticalr2InsideOfr1 = r2HeightDistanceNegativeSide && r2HeightDistancePositiveSide;


        final boolean r1WidthDistanceNegativeSide = (r1x1 - r1width / 2 >= r2x2 - r2width / 2);
        final boolean r1WidthDistancePositiveSide = (r1x1 + r1width / 2 <= r2x2 + r2width / 2);
        final boolean r1HeightDistanceNegativeSide = (r1y1 - r1height / 2 >= r2y2 - r2height / 2);
        final boolean r1HeightDistancePositiveSide = (r1y1 + r1height / 2 <= r2y2 + r2height / 2);
        final boolean horizontalr1InsideOfr2 = r1WidthDistanceNegativeSide && r1WidthDistancePositiveSide;
        final boolean verticalr1InsideOfr2 = r1HeightDistanceNegativeSide && r1HeightDistancePositiveSide;


        final boolean horizontalOverlapsNegativeSide = (r1x1 - r1width / 2 <= r2x2 + r2width / 2);
        final boolean horizontalOverlapsPositiveSide = (r1x1 + r1width / 2 >= r2x2 - r2width / 2);
        final boolean vertivalOverlapsNegativeSide = (r1x1 - r1height / 2 <= r2x2 + r2height / 2);
        final boolean vertivalOverlapsPositiveSide = (r1x1 + r1height / 2 >= r2x2 - r2height / 2);
        final boolean horizontalr2Overlapsr1 = horizontalOverlapsNegativeSide && horizontalOverlapsPositiveSide;
        final boolean verticalr2Overlapsr1 = vertivalOverlapsNegativeSide && vertivalOverlapsPositiveSide;

        if (horizontalr2InsideOfr1 && verticalr2InsideOfr1) {
            System.out.println("r2 is inside r1");
        } else if (horizontalr1InsideOfr2 && verticalr1InsideOfr2) {
            System.out.println("r1 is inside r2");
        } else if (horizontalr2Overlapsr1 && verticalr2Overlapsr1) {
            System.out.println("r2 overlaps r1");
        } else {
            System.out.println("r2 does not overlap r1");
        }
    }
}