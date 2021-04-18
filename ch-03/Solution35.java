import java.util.Scanner;

public class Solution35 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        System.out.println("Enter today's day (Monday = 0 ..... Sunday = 6): ");
        final int todaysDay = input.nextInt();

        System.out.println("Enter the days elapsed since today: ");
        final int elapsedDays = input.nextInt();

        final boolean isMonday = (todaysDay + elapsedDays) % 7 == 0;
        final boolean isTuesday = (todaysDay + elapsedDays) % 7 == 1;
        final boolean isWednesday = (todaysDay + elapsedDays) % 7 == 2;
        final boolean isThursday = (todaysDay + elapsedDays) % 7 == 3;
        final boolean isFriday = (todaysDay + elapsedDays) % 7 == 4;
        final boolean isSaturday = (todaysDay + elapsedDays) % 7 == 5;
        final boolean isSunday = (todaysDay + elapsedDays) % 7 == 6;

        final String todaysDayIs;

        if (todaysDay == 0) 
            todaysDayIs = "Monday";
         else if (todaysDay == 1) 
            todaysDayIs = "Tuesday";
         else if (todaysDay == 2) 
            todaysDayIs = "Wednesday";
         else if (todaysDay == 3) 
            todaysDayIs = "Thursday";
         else if (todaysDay == 4) 
            todaysDayIs = "Friday";
         else if (todaysDay == 5) 
            todaysDayIs = "Saturday";
         else 
            todaysDayIs = "Sunday";
        
        
        final String futureDayIs;

        if (isMonday) {
            futureDayIs = "Monday";
        } else if (isTuesday) {
            futureDayIs = "Tuesday";
        } else if (isWednesday) {
            futureDayIs = "Wednesday";
        } else if (isThursday) {
            futureDayIs = "Thursday";
        } else if (isFriday) {
            futureDayIs = "Friday";
        } else if (isSaturday) {
            futureDayIs = "Saturday";
        } else {
            futureDayIs = "Sunday";
        }

        System.out.println("Today is " + todaysDayIs + " and the future day is " + futureDayIs);
    }
}