import java.util.Scanner;

public class SOlution516 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int n = 1;

        if (number > 1) {
            while (number != 1) {
                if (isPrime(n)) {
                    if (number % n == 0) {
                        System.out.printf("%d ", n);
                        number /= n;
                        n = 1;
                    }
                }
                n++;
            }
        } else {
            System.out.println("Enter a positive integer which is larger than 1");
        }
    }

    public static boolean isPrime(final int n) {
        if (n == 2) {
            return true;
        }
        if (n <= 1 || n % 2 == 0) {
            return false;
        }
        for (int i = 3; i < (n / 2); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
