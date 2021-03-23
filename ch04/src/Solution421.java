import java.util.Scanner;

public class Solution421 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        System.out.println("Enter an SSN:");

        final String socSecNumber = input.nextLine();
        final boolean isTheFourthAndSeventhCharIsTheSame = (int)(socSecNumber.charAt(3)) == (int)(socSecNumber.charAt(6));
        final boolean areThemDashes = (int)(socSecNumber.charAt(3)) == (int)('-');
        final boolean isLengthValid = socSecNumber.length() == 11;

        final String[] numbers = socSecNumber.split("-", 3);

        if (isTheFourthAndSeventhCharIsTheSame && areThemDashes && isLengthValid) {
            try {
                Integer.parseInt(numbers[0]);
                Integer.parseInt(numbers[1]);
                Integer.parseInt(numbers[2]);
                System.out.printf("%s is a valid social security number", socSecNumber);
            } catch (Exception e) {
                System.out.printf("%s is an invalid social security number", socSecNumber);
            }
        } else {
            System.out.printf("%s is an invalid social security number", socSecNumber);
        }
    }
}
