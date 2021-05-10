import java.util.Scanner;

public class Solution89 {
    public static void main(String[] args) {
        final int SIZE_OF_TABLE = 3;
        final Scanner input = new Scanner(System.in);
        final String[][] table = new String[SIZE_OF_TABLE][SIZE_OF_TABLE];

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                table[i][j] = "";
            }
        }

        final String mark1 = "X";
        final String mark2 = "O";
        String player = "X";
        int turnCounter = 0;

        while (true) {
            printTable(table);

            System.out.printf("Enter a row (0, 1, or 2) for player %s:\n", player);
            final int row = input.nextInt();

            System.out.printf("Enter a column (0, 1, or 2) for player %s:\n", player);
            final int column = input.nextInt();

            if (row < 0 || row > SIZE_OF_TABLE - 1 || column < 0 || column > SIZE_OF_TABLE) {
                System.out.println("Chose from 0, 1 or 2");
                continue;
            }

            if (table[row][column].equals("X") || table[row][column].equals("O")) {
                System.out.println("That cell is already marked!");
                continue;
            }

            table[row][column] = player;
            turnCounter++;

            if (checkForWin(table)) {
                printTable(table);
                System.out.printf("%s Player won!", player);
                break;
            }

            if (turnCounter == SIZE_OF_TABLE * SIZE_OF_TABLE) {
                printTable(table);
                System.out.println("It's a draw!");
                break;
            }

            if (player.equals(mark1)) {
                player = mark2;
            } else {
                player = mark1;
            }
        }
    }

    public static boolean checkForWin(final String[][] table) {
        return checkRows(table) || checkColumns(table) || checkDiagonal(table);
    }

    public static boolean checkDiagonal(final String[][] table) {
        boolean checkIfTrue = true;

        for (int i = 1; i < table.length; i++) {
            final String checker = table[0][0];

            if (checker.equals("")) {
                checkIfTrue = false;
                break;
            }

            if (!checker.equals(table[i][i])) {
                checkIfTrue = false;
                break;
            }
        }

        if (checkIfTrue) {
            return true;
        }

        for (int i = 1, j = 1; i < table.length && j >= 0; i++, j--) {
            final String checker = table[0][table.length - 1];

            if (checker.equals("")) {
                return false;
            }

            if (!checker.equals(table[i][j])) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkColumns(final String[][] table) {
        for (int i = 0; i < table[0].length; i++) {
            boolean checkIfTrue = true;
            final String checker = table[0][i];

            if (checker.equals("")) {
                continue;
            }

            for (int j = 1; j < table.length; j++) {
                if (!checker.equals(table[j][i])) {
                    checkIfTrue = false;
                    break;
                }
            }

            if (checkIfTrue) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkRows(final String[][] table) {
        for (final String[] row : table) {
            boolean checkIfTrue = true;
            final String checker = row[0];

            if (checker.equals("")) {
                continue;
            }

            for (int j = 1; j < table[0].length; j++) {
                if (!checker.equals(row[j])) {
                    checkIfTrue = false;
                    break;
                }
            }

            if (checkIfTrue) {
                return true;
            }
        }
        return false;
    }

    public static void printTable(final String[][] table) {
        System.out.println("-".repeat("|     |     |     |".length()));

        for (final String[] row : table) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.printf("|  %1s  ", row[j]);
            }
            System.out.print("|\n");
            System.out.println("-".repeat("|     |     |     |".length()));
        }
    }
}
