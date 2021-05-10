import java.util.Arrays;
import java.util.Scanner;

public class Sudoku {
    public static void main(String[] args) {
        final int NUMBER_OF_ROWS_AND_COLUMNS = 9;
        final Scanner input = new Scanner(System.in);
        final int[][] sudokuSolution = new int[NUMBER_OF_ROWS_AND_COLUMNS][NUMBER_OF_ROWS_AND_COLUMNS];

        System.out.println("Enter a sudoku puzzle solution:");

        for (int i = 0; i < NUMBER_OF_ROWS_AND_COLUMNS; i++) {
            for (int j = 0; j < NUMBER_OF_ROWS_AND_COLUMNS; j++) {
                final int nextNumber = input.nextInt();

                if (nextNumber < 1 || nextNumber > NUMBER_OF_ROWS_AND_COLUMNS) {
                    System.out.println("Invalid input");
                    System.exit(1);
                } else {
                    sudokuSolution[i][j] = nextNumber;
                }
            }
        }

        if (solutionChecker(sudokuSolution)) {
            System.out.println("Valid solution");
        } else {
            System.out.println("Invalid solution");
        }
    }

    public static boolean solutionChecker(final int[][] sudokuSolution) {
        return checkBoxes(sudokuSolution) && checkColumns(sudokuSolution) && checkRows(sudokuSolution);
    }

    public static boolean checkBoxes(final int[][] sudokuSolution) {
        final int LENGTH_OF_BOXES = 3;
        final int[] boxChecker = new int[LENGTH_OF_BOXES * LENGTH_OF_BOXES];

        for (int i = 0; i < sudokuSolution.length; i += LENGTH_OF_BOXES) {
            for (int j = 0; j < sudokuSolution[0].length; j += LENGTH_OF_BOXES) {
                Arrays.fill(boxChecker, 0);

                for (int k = j; k < LENGTH_OF_BOXES + j; k++) {
                    for (int l = i; l < LENGTH_OF_BOXES + i; l++) {
                        if (sudokuSolution[k][l] == boxChecker[sudokuSolution[k][l] - 1]) {
                            return false;
                        } else {
                            boxChecker[sudokuSolution[k][l] - 1] = sudokuSolution[k][l];
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean checkColumns(final int[][] sudokuSolution) {
        final int[] columnChecker = new int[sudokuSolution.length];

        for (int i = 0; i < columnChecker.length; i++) {
            Arrays.fill(columnChecker, 0);

            for (int j = 0; j < columnChecker.length; j++) {
                if (sudokuSolution[j][i] == columnChecker[sudokuSolution[j][i] - 1]) {
                    return false;
                } else {
                    columnChecker[sudokuSolution[j][i] - 1] = sudokuSolution[j][i];
                }
            }
        }
        return true;
    }

    public static boolean checkRows(final int[][] sudokuSolution) {
        final int[] rowChecker = new int[sudokuSolution[0].length];

        for (final int[] row : sudokuSolution) {
            Arrays.fill(rowChecker, 0);

            for (int i = 0; i < rowChecker.length; i++) {
                if (row[i] == rowChecker[row[i] - 1]) {
                    return false;
                } else {
                    rowChecker[row[i] - 1] = row[i];
                }
            }
        }
        return true;
    }
}
