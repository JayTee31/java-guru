import java.util.Scanner;

public class SubtractionQuiz {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        int number1 = (int)(Math.random() * 25 + 50);
        int number2 = (int)(Math.random() * 25 + 50);

        if (number1 < number2) {
            final int number1Tarolo = number1;
            number1 = number2;
            number2 = number1Tarolo;
        }
        System.out.println("What is " + number1 + " - " + number2);
        final int guess = input.nextInt();
        final int solution = number1 - number2;
        if (guess == solution) {
            System.out.println("Mo-mo-mo-mo MONSTER KILL!");
        } else {
            System.out.println("You are trash, the solution is: " + solution);
        }
    }
}