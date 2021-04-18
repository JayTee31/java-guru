import java.util.Scanner;

public class Solution414 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        System.out.println("Enter a letter grade:");

        final char letterGrade = Character.toUpperCase(input.nextLine().charAt(0));
        final int letterNumeric = (int)letterGrade - (int)'E';

        if (letterNumeric >= -4 && letterNumeric <= -1) {
            System.out.printf("The numeric value for grade %c is %d", letterGrade, Math.abs(letterNumeric));
        } else if (letterNumeric == 1) {
            System.out.printf("The numeric value for grade %c is 0", letterGrade);
        } else {
            System.out.printf("%c is an invalid grade", letterGrade);
        }
    }
}
