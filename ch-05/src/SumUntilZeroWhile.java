import java.util.Scanner;

public class SumUntilZeroWhile {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        int addition = 0;
        int number;

        while (true) {
            System.out.println("Enter a number");
            number = input.nextInt();
            addition += number;
            if (number == 0) {
                break;
            }
        }
        System.out.println(addition);
    }
}
