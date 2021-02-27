import java.util.Scanner;

public class Solution27 {
    public static void main(String[] args) {
        final long MINUTES_IN_A_DAY = 1440;
        final long DAYS_IN_A_YEAR = 365;

        final Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of minutes: ");
        final long minutes = input.nextLong();

        final long daysInInputMinutes = minutes / MINUTES_IN_A_DAY;
        final long days = daysInInputMinutes % DAYS_IN_A_YEAR;
        final long years = daysInInputMinutes / DAYS_IN_A_YEAR;

        System.out.println(minutes + " minutes is approximately " + years + " and " + days + " days");
    }
}