import java.util.Scanner;

public class Solution820 {
    public static void main(String[] args) {
        final int NUMBER_OF_ROWS = 6;
        final int NUMBER_OF_COLUMNS = 7;
        final Scanner input = new Scanner(System.in);
        final String[][] board = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        final String player1 = "Red";
        final String player2 = "Yellow";
        String nextPlayer = player1;
        int tryingFullColumn = 3;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = "";
            }
        }

        while (true) {
            printBoard(board);

            if (isDraw(board)) {
                System.out.println("It's a draw!");
                break;
            }

            System.out.printf("Drop a %c disk at column (0-6): \n", nextPlayer.charAt(0));

            final int playersChosenColumn = input.nextInt();

            if (isChosenColumnFull(board, playersChosenColumn)) {
                if (tryingFullColumn == 0) {
                    System.out.printf("The %s player lost due to too much attempt to chose a free column", nextPlayer);
                    break;
                } else {
                    System.out.printf("That column is full, pick another one! Remained attempt: %d\n", tryingFullColumn);
                    tryingFullColumn--;
                    continue;
                }
            }

            dropDiskToTheBottom(board, String.valueOf(nextPlayer.charAt(0)), playersChosenColumn);

            if (checkForWin(board)) {
                printBoard(board);
                System.out.printf("The %s player won!", nextPlayer);
                break;
            }

            nextPlayer = changePlayer(nextPlayer, player1, player2);

            tryingFullColumn = 3;
        }
    }

    public static boolean checkForWin(final String[][] board) {
        return checkDiagonal(board) || checkRows(board) || checkColumns(board);
    }

    public static boolean checkDiagonal(final String[][] board) {
        return checkDiagonalFirstHalf(board) || checkDiagonalSecondHalf(board);
    }

    public static boolean checkDiagonalFirstHalf(final String[][] board) {
        return checkDiagonalFirstHalfHorizontal(board) || checkDiagonalFirstHalfVertical(board);
    }

    public static boolean checkDiagonalSecondHalf(final String[][] board) {
        return checkDiagonalSecondHalfHorizontal(board) || checkDiagonalSecondHalfVertical(board);
    }

    public static boolean checkDiagonalFirstHalfHorizontal(final String[][] board) {
        final int NUMBER_TO_WIN = 4;

        for (int i = 0; i < board[0].length; i++) {
            int countDisks = 1;
            String checkerHorizontal = board[0][i];

            for (int j = i + 1, k = 1; j < board[0].length && k < board.length; j++, k++) {

                if (checkerHorizontal.isEmpty()) {
                    checkerHorizontal = board[k][j];
                    countDisks = 1;
                    continue;
                }

                if (checkerHorizontal.equals(board[k][j])) {
                    countDisks++;
                } else {
                    checkerHorizontal = board[k][j];
                    countDisks = 1;
                }

                if (countDisks == NUMBER_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkDiagonalFirstHalfVertical(final String[][] board) {
        final int NUMBER_TO_WIN = 4;

        for (int i = 0; i < board.length; i++) {
            int countDisks = 1;
            String checkerVertical = board[i][0];

            for (int j = i + 1, k = 1; j < board.length && k < board[0].length; j++, k++) {

                if (checkerVertical.isEmpty()) {
                    checkerVertical = board[j][k];
                    countDisks = 1;
                    continue;
                }

                if (checkerVertical.equals(board[j][k])) {
                    countDisks++;
                } else {
                    checkerVertical = board[j][k];
                    countDisks = 1;
                }

                if (countDisks == NUMBER_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkDiagonalSecondHalfHorizontal(final String[][] board) {
        final int NUMBER_TO_WIN = 4;

        for (int i = board[0].length - 1; i >= 0; i--) {
            int countDisks = 1;
            String checkerHorizontal = board[0][i];

            for (int j = i - 1, k = 1; j >= 0 && k < board.length; j--, k++) {

                if (checkerHorizontal.isEmpty()) {
                    checkerHorizontal = board[k][j];
                    countDisks = 1;
                    continue;
                }

                if (checkerHorizontal.equals(board[k][j])) {
                    countDisks++;
                } else {
                    checkerHorizontal = board[k][j];
                    countDisks = 1;
                }

                if (countDisks == NUMBER_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkDiagonalSecondHalfVertical(final String[][] board) {
        final int NUMBER_TO_WIN = 4;

        for (int i = 0; i < board.length; i++) {
            int countDisks = 1;
            String checkerVertical = board[i][board[0].length - 1];

            for (int j = i + 1, k = board[0].length - 2; j < board.length && k >= 0; j++, k--) {

                if (checkerVertical.isEmpty()) {
                    checkerVertical = board[j][k];
                    countDisks = 1;
                    continue;
                }

                if (checkerVertical.equals(board[j][k])) {
                    countDisks++;
                } else {
                    checkerVertical = board[j][k];
                    countDisks = 1;
                }

                if (countDisks == NUMBER_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkColumns(final String[][] board) {
        final int NUMBER_TO_WIN = 4;
        int countDisks = 1;

        for (int i = 0; i < board[0].length; i++) {
            String checker = board[0][i];

            for (int j = 1; j < board.length; j++) {
                if (checker.isEmpty()) {
                    checker = board[j][i];
                    countDisks = 1;
                    continue;
                }

                if (checker.equals(board[j][i])) {
                    countDisks++;
                } else {
                    checker = board[j][i];
                    countDisks = 1;
                }

                if (countDisks == NUMBER_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkRows(final String[][] board) {
        final int NUMBER_TO_WIN = 4;
        int countDisks = 1;

        for (String[] row : board) {
            String checker = row[0];

            for (int j = 1; j < board[0].length; j++) {
                if (checker.isEmpty()) {
                    checker = row[j];
                    countDisks = 1;
                    continue;
                }

                if (checker.equals(row[j])) {
                    countDisks++;
                } else {
                    checker = row[j];
                    countDisks = 1;
                }

                if (countDisks == NUMBER_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isDraw(final String[][] board) {
        for (String[] row : board) {
            for (int j = 0; j < board[0].length; j++) {
                if (row[j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String changePlayer(String nextPlayer, final String player1, final String player2) {
        if (nextPlayer.equals(player1)) {
            nextPlayer = player2;
        } else {
            nextPlayer = player1;
        }
        return nextPlayer;
    }

    public static boolean isChosenColumnFull(final String[][] board, final int chosenColumn) {
        return !board[0][chosenColumn].isEmpty();
    }

    public static void dropDiskToTheBottom(final String[][] board, final String disk, final int column) {
        for (int i = board.length - 1; i >= 0; i--) {
            if (board[i][column].isEmpty()) {
                board[i][column] = disk;
                break;
            }
        }
    }

    public static void printBoard(final String[][] board) {
        for (final String[] row : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.printf("| %1s ", row[j]);
            }
            System.out.print("|\n");
        }
        System.out.println("-".repeat("|   ".length() * board[0].length + 1));
    }
}
