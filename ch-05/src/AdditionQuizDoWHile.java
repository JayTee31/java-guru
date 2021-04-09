import java.util.Scanner;

public class AdditionQuizDoWHile {
    public static void main(String[] args) {
        final int number1 = (int)(Math.random() * 10);
        final int number2 = (int)(Math.random() * 10);
        final int answer = number1 + number2;

        final Scanner input = new Scanner(System.in);
        System.out.printf("What is the sum of %d and %d?\n", number1, number2);
        int guess;

        do {
            guess = input.nextInt();
            if (guess != answer) {
                System.out.println("Hülye vagy mint a seggem, gondolkodjál az agyaddal mégegyszer!");
            }
        } while (guess != answer);
        System.out.println("Nem vagy olyan szar mint aminek kinézel");
    }
}
