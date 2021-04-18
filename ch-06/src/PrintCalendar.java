import java.util.List;
import java.util.Scanner;

public class PrintCalendar {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter a year:");
        final int year = input.nextInt();

        System.out.println("Enter a month:");
        final int month = input.nextInt();

        final int firstDayOfMonth = calculateFirstDayOfMonth(year, month);
        System.out.println(firstDayOfMonth);

        final int daysInMonth = calculateDaysInMonth(year, month);
        System.out.println(daysInMonth);

        printCalendar(year, month, firstDayOfMonth, daysInMonth);
    }

    private static void printCalendar(int year, int month, int firstDayOfMonth, int daysInMonth) {
        printHeadLine(year, month);
        printDays(firstDayOfMonth, daysInMonth);
    }

    private static void printDays(int firstDayOfMonth, int daysInMonth) {
        System.out.print("    ".repeat(firstDayOfMonth));

        for (int i = 1; i <= daysInMonth; i++) {
            boolean isTheDayTheLastDayInTheWeek = (i + firstDayOfMonth) % 7 == 0;

            System.out.printf("%4d", i);
            if (isTheDayTheLastDayInTheWeek) {
                System.out.println();
            }
        }
    }

    private static void printHeadLine(int year, int month) {
        final String DAYS_OF_CALENDAR = " Mon Tue Wed Thu Fri Sat Sun ";
        final int LENGTH_OF_THE_CALENDAR = DAYS_OF_CALENDAR.length();

        final String monthName = attachMonthNameToANumber(month);
        final String headLine = monthName + " " + year;

        System.out.print(" ".repeat((LENGTH_OF_THE_CALENDAR - headLine.length()) / 2));
        System.out.println(headLine);
        System.out.println("-".repeat(LENGTH_OF_THE_CALENDAR));
        System.out.println(DAYS_OF_CALENDAR);
    }

    private static String attachMonthNameToANumber(int month) {
        return List.of("January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December").get(month - 1);
    }

    private static int calculateDaysInMonth(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: return 31;
            case 4:
            case 6:
            case 9:
            case 11: return 30;
            case 2: if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
            default: return 0;
        }
    }

    private static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    private static int calculateFirstDayOfMonth(int year, int month) {
        int daysPassed = calculateFirstDayOfYear(year);

        for(int i = 1; i < month; i++) {
            daysPassed += calculateDaysInMonth(year, i);
        }
        return daysPassed % 7;
    }

    private static int calculateFirstDayOfYear(int year) {
        final int FIRST_DAY_IN_1800 = 2;
        int daysPassed = FIRST_DAY_IN_1800;

        for (int i = 1800; i < year; i++) {
            if (isLeapYear(i)) {
                daysPassed += 366;
            } else {
                daysPassed += 365;
            }
        }
        return daysPassed % 7;
    }
}