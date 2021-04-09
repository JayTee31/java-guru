import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final int number1 = input.nextInt();
        final int number2 = input.nextInt();
        final int lowerNumber = Math.min(number1, number2);

        for (int i = lowerNumber; i > 0; i--) {
            if (number1 % i == 0 && number2 % i == 0) {
                System.out.println("GCD: " + i);
                break;
            }
        }
    }
}
