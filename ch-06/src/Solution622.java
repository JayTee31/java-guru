import java.util.Scanner;

public class Solution622 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final long number = input.nextLong();

        System.out.println("The square root of the number is: " + sqrt(number));
    }

    public static double sqrt(long n) {
        final double EPSILON = 0.0001;
        double lastGuess = 1;
        double nextGuess;

       while (true) {
            nextGuess = (lastGuess + n / lastGuess) / 2;

            if (Math.abs(lastGuess - nextGuess) <= EPSILON) {
                return nextGuess;
            }
            lastGuess = nextGuess;
       }
    }
}
