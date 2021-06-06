public class Application630 {
    public static void main(String[] args) {
        int firstDiceInFirstRoll = rollTheDice();
        int secondDiceInFirstRoll = rollTheDice();
        final int sumOfFirstRoll = firstDiceInFirstRoll + secondDiceInFirstRoll;

        System.out.printf("You rolled %d + %d = %d\n", firstDiceInFirstRoll, secondDiceInFirstRoll, sumOfFirstRoll);

        if (isThePlayerWinningAfterFirstRoll(sumOfFirstRoll)) {
            System.out.println("You win!");

        } else if (isThePlayerLosingAfterFirstRoll(sumOfFirstRoll)) {
            System.out.println("You lose!");

        } else if (isThePlayerWinningAfterSecondRoll(rollTheSecond(sumOfFirstRoll))) {
            System.out.println("You rolled the same as the first roll, you win!");

        } else {
            System.out.println("You rolled 7 as your second roll, you lose!");
        }
    }

    public static boolean isThePlayerWinningAfterSecondRoll(final int sumOfSecondRoll) {
        return sumOfSecondRoll != 7;
    }

    public static boolean isThePlayerLosingAfterFirstRoll(int n) {
        if (n < 2 || n > 12) {
            throw new IllegalArgumentException("Meh");
        }

        switch (n) {
            case 2:
            case 3:
            case 12: return true;
            default: return false;
        }
    }

    public static boolean isThePlayerWinningAfterFirstRoll(int n) {
        if (n < 2 || n > 12) {
            throw new IllegalArgumentException("Pff");
        }

        switch (n) {
            case 7:
            case 11: return true;
            default: return false;
        }
    }

    public static int rollTheSecond(final int firstRoll) {
        int sumOfSecondRoll;

        while (true) {
            sumOfSecondRoll = rollTheDice() + rollTheDice();

            if (sumOfSecondRoll == 7 || sumOfSecondRoll == firstRoll) {
                return sumOfSecondRoll;
            }
        }
    }

    public static int rollTheDice() {
        return (int)((Math.random() * 6) + 1);
    }
}