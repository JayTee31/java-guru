import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        final int number = (int)(Math.random() * 101);
        final Scanner input = new Scanner(System.in);
        System.out.println("Tippelj");

        while (true) {
            final int guess = input.nextInt();
            if (guess == number) {
                System.out.println("Fasza gyerek vagy");
                break;
            } else if (guess > number) {
                System.out.println("Kisebb szám lesz az, tippelj újra");
            } else {
                System.out.println("Nagyobb szám lesz az, tippelj újra");
            }
        }

    }
}
