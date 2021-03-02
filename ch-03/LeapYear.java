import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final int year = input.nextInt();

        // szökőév: osztható 4-el, de nem osztható 100-al, vagy osztható 400-al

        boolean isLeapYear = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);

        if (isLeapYear) {
            System.out.println(year + " is a leap year");
        } else {
            System.out.println(year + " is not a leap year");
        }
    }
}