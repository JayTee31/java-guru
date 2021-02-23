import java.util.Scanner;

public class DisplayTime {
    public static void main(String[] args) {
        // Prompt the user for input
        System.out.print("Enter an integer for seconds: ");
        final Scanner input = new Scanner(System.in);
        final long seconds = input.nextLong();

        final long SECONDS_IN_A_MINUTE = 60L;
        final long SECONDS_IN_AN_HOUR = 60L * SECONDS_IN_A_MINUTE;

        final long hours = seconds / SECONDS_IN_AN_HOUR;  // Find minutes in seconds
        final long remainingSecondsToAnHour = seconds % SECONDS_IN_AN_HOUR;

        final long minutes = remainingSecondsToAnHour / SECONDS_IN_A_MINUTE;  // Find minutes in seconds
        final long remainingSecondsToAMinute = remainingSecondsToAnHour % SECONDS_IN_A_MINUTE;  // Seconds remaining

        System.out.println(seconds + " seconds is " + hours + " hours and "
            + minutes + " minutes and " + remainingSecondsToAMinute + " seconds");
    }
}