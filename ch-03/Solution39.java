import java.util.Scanner;

public class Solution39 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter the first 9 digits of an ISBN");
        final String isbnNineDigits = input.nextLine();

        if (isbnNineDigits.length() != 9) {
            System.out.println("You didn't enter exactly 9 digits, try it again.");
        } else {
            int[] allNumbers;
            allNumbers = new int[9];
            int d10 = 0;

            for (int d = 0, digitsOfTheNumber = 0; d <= 8 && digitsOfTheNumber <= 8; d++, digitsOfTheNumber++) {
            allNumbers[d] = Integer.parseInt(isbnNineDigits.charAt(digitsOfTheNumber) + "");
            d10 = (d10 + (d + 1) * allNumbers[d]) % 11;
            }

            if (d10 < 10) {
            final String fullISBN = isbnNineDigits + String.valueOf(d10);
            System.out.println("The ISBN-10 number is: " + fullISBN);
            } else {
            System.out.println("The ISBN-10 number is: " + isbnNineDigits + "X");
            }
        }
    }
}