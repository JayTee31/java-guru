import java.util.Scanner;

public class Max {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        int higherValue = Integer.MIN_VALUE;
        int number;

        do {
            System.out.println("Enter a number");
            number = input.nextInt();
            if (higherValue <= number) {
                higherValue = number;
            }
        } while (number != 0);
        System.out.println(higherValue);
    }
}
