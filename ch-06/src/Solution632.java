public class Solution632 {
    public static void main(String[] args) {
        final int NUMBER_OF_GAMES = 15000;
        int losingCounter = 0;
        int winningCounter = 0;

        for (int i = 1; i <= NUMBER_OF_GAMES; i++) {
            int firstDiceInFirstRoll = rollTheDice();
            int secondDiceInFirstRoll = rollTheDice();
            final int sumOfFirstRoll = firstDiceInFirstRoll + secondDiceInFirstRoll;

            if (isThePlayerWinningAfterFirstRoll(sumOfFirstRoll)) {
                winningCounter++;

            } else if (isThePlayerLosingAfterFirstRoll(sumOfFirstRoll)) {
                losingCounter++;

            } else if (isWinningInSecondRoll(sumOfFirstRoll)) {
                winningCounter++;

            } else {
                losingCounter++;
            }
        }
        System.out.printf("From %d games:\n -Winning: %d\n -Losing: %d\n -Chance of winning: %f%%",
                NUMBER_OF_GAMES,winningCounter, losingCounter, ((double)winningCounter / NUMBER_OF_GAMES) * 100);
    }

    public static boolean isWinningInSecondRoll(int n) {
        int firstDiceInSecondRoll;
        int secondDiceInSecondRoll;
        int sumOfSecondRoll;

        do {
            firstDiceInSecondRoll = rollTheDice();
            secondDiceInSecondRoll = rollTheDice();
            sumOfSecondRoll = firstDiceInSecondRoll + secondDiceInSecondRoll;

            if (sumOfSecondRoll == 7) {
                return false;

            } else if (sumOfSecondRoll == n) {
                return true;
            }

        } while (true);
    }

    public static boolean isThePlayerLosingAfterFirstRoll(int n) {
        switch (n) {
            case 2:
            case 3:
            case 12: return true;
            default: return false;
        }
    }

    public static boolean isThePlayerWinningAfterFirstRoll(int n) {
        switch (n) {
            case 7:
            case 11: return true;
            default: return false;
        }
    }

    public static int rollTheDice() {
        return (int)((Math.random() * 6) + 1);
    }
}
