import java.util.Arrays;
import java.util.Scanner;

public class FindingClosestPair {
    public static void main(String[] args) {
        final int NUMBER_OF_COORDINATES = 2;
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of points:");
        final int numberOfPoints = input.nextInt();

        if (numberOfPoints == 0 || numberOfPoints == 1) {
            System.out.println("Uninterpretable number");
            System.exit(1);
        }

        final double[][] points = new double[numberOfPoints][NUMBER_OF_COORDINATES];

        for (int i = 0; i < numberOfPoints; i++) {
            for (int j = 0; j < NUMBER_OF_COORDINATES; j++) {
                points[i][j] = input.nextDouble();
            }
        }

        printResults(points);
    }

    public static void printResults(final double[][] arrayOfPoints) {
        final double[][] closestPoints = getClosestPoints(arrayOfPoints, calculateDistanceBetweenPoints(arrayOfPoints));

        for (final double[] value : closestPoints) {
            System.out.printf("The closest points are (%f, %f) and (%f, %f)\n",
                    value[0], value[1], value[2], value[3]);
        }

        System.out.printf("Their distance is: %f", getMinimumDistance(calculateDistanceBetweenPoints(arrayOfPoints)));
    }

    public static double[][] getClosestPoints(final double[][] arrayOfPoints, final double[] distanceBetweenPoints) {
        // x1, y1, x2, y2
        final int NUMBER_OF_DATA_IN_A_ROW = 4;
        final int NUMBER_OF_ROWS = getNumberOfClosestPairs(calculateDistanceBetweenPoints(arrayOfPoints));
        final double[][] closestPoints = new double[NUMBER_OF_ROWS][NUMBER_OF_DATA_IN_A_ROW];
        int comparisonCount = 0;
        int numberOfPairs = 0;

        for (int i = 0; i < arrayOfPoints.length - 1; i++) {
            for (int j = i + 1; j < arrayOfPoints.length; j++) {
                if (distanceBetweenPoints[comparisonCount] == getMinimumDistance(distanceBetweenPoints)) {
                    closestPoints[numberOfPairs][0] = arrayOfPoints[i][0];
                    closestPoints[numberOfPairs][1] = arrayOfPoints[i][1];
                    closestPoints[numberOfPairs][2] = arrayOfPoints[j][0];
                    closestPoints[numberOfPairs][3] = arrayOfPoints[j][1];
                    numberOfPairs++;
                }
                comparisonCount++;
            }
        }
        return closestPoints;
    }

    public static double[] calculateDistanceBetweenPoints(final double[][] arrayOfPoints) {
        final int NUMBER_OF_COMPARISONS = (int)(0.5 * (Math.pow(arrayOfPoints.length, 2) - arrayOfPoints.length));
        final double[] distanceBetweenPoints = new double[NUMBER_OF_COMPARISONS];
        int comparisonCount = 0;

        for (int i = 0; i < arrayOfPoints.length - 1; i++) {
            for (int j = i + 1; j < arrayOfPoints.length; j++) {
                distanceBetweenPoints[comparisonCount] = computeDistance(
                        arrayOfPoints[i][0],
                        arrayOfPoints[i][1],
                        arrayOfPoints[j][0],
                        arrayOfPoints[j][1]);
                comparisonCount++;
            }
        }
        return distanceBetweenPoints;
    }

    public static double computeDistance(final double x1, final double y1, final double x2, final double y2) {
        return Math.pow(Math.pow((x2 - x1), 2) + Math.pow(y2 - y1, 2), 0.5);
    }

    public static double getMinimumDistance(final double[] distanceBetweenPoints) {
        final double[] copyOfArray = Arrays.copyOf(distanceBetweenPoints, distanceBetweenPoints.length);
        Arrays.sort(copyOfArray);
        return copyOfArray[0];
    }

    public static int getNumberOfClosestPairs(final double[] distanceBetweenPoints) {
        final double[] copyOfArray = Arrays.copyOf(distanceBetweenPoints, distanceBetweenPoints.length);
        Arrays.sort(copyOfArray);
        int numberOfClosestPairs = 1;

        for (int i = 0; i < copyOfArray.length; i++) {
            if (copyOfArray[i] == copyOfArray[i + 1]) {
                numberOfClosestPairs++;
            } else {
                break;
            }
        }

        return numberOfClosestPairs;
    }
}
