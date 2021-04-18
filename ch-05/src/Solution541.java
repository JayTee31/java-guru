import java.util.Scanner;

public class Solution541 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        int max = 0;
        int count = 0;

        while (true) {
            int number = input.nextInt();

            if (number == 0) {
                break;
            }

            if (number > max) {
                max = number;
                count = 1;
            } else if (number == max) {
                count++;
            }
        }
        System.out.printf("Largest number: %d, count: %d", max, count);
    }
}
