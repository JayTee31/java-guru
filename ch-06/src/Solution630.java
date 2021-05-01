public class Solution630 {
    public static void main(String[] args) {
        int firstDiceInFirstRoll = rollTheDice();
        int secondDiceInFirstRoll = rollTheDice();
        final int sumOfFirstRoll = firstDiceInFirstRoll + secondDiceInFirstRoll;

        System.out.printf("You rolled %d + %d = %d\n", firstDiceInFirstRoll, secondDiceInFirstRoll, sumOfFirstRoll);

        if (isThePlayerWinningAfterFirstRoll(sumOfFirstRoll)) {
            System.out.println("You win");

        } else if (isThePlayerLosingAfterFirstRoll(sumOfFirstRoll)) {
            System.out.println("You lose");

        } else {
            System.out.println("Point is: " + sumOfFirstRoll);
            RollSecondUntilGetSevenOrFirstRoll(sumOfFirstRoll);
        }
    }

    public static void RollSecondUntilGetSevenOrFirstRoll(int n) {
        int firstDiceInSecondRoll;
        int secondDiceInSecondRoll;
        int sumOfSecondRoll;

        do {
            firstDiceInSecondRoll = rollTheDice();
            secondDiceInSecondRoll = rollTheDice();
            sumOfSecondRoll = firstDiceInSecondRoll + secondDiceInSecondRoll;

            if (sumOfSecondRoll == 7) {
                System.out.printf("You rolled %d + %d = %d\n You lose", firstDiceInSecondRoll, secondDiceInSecondRoll, sumOfSecondRoll);

            } else if (sumOfSecondRoll == n) {
                System.out.printf("You rolled %d + %d = %d\n You win", firstDiceInSecondRoll, secondDiceInSecondRoll, sumOfSecondRoll);
            }

        } while (sumOfSecondRoll != 7 && sumOfSecondRoll != n);
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
