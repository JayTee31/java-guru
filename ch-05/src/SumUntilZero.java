import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        int addition = 0;
        int number;

        do {
            System.out.println("Enter a number");
            number = input.nextInt();
            addition += number;
        } while (number != 0);
        System.out.println(addition);
    }
}
