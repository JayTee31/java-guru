import java.util.Scanner;

public class Primes {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final int number = input.nextInt();
        boolean isPrime = true;

        if (number <= 1) {
            isPrime = false;
        }
        if (number != 2) {
            if (number % 2 == 0) {
                isPrime = false;
            } else {
                for (int i = 3; i < Math.pow(number, 0.5); i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
        }
        if (isPrime) {
            System.out.println("The number is a Prime");
        } else {
            System.out.println("The number is not a Prime");
        }
    }
}
