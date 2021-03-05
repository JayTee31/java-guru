import java.util.Scanner;

public class Solution38 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        System.out.println("Enter 3 integers: ");
        final int number1 = input.nextInt();
        final int number2 = input.nextInt();
        final int number3 = input.nextInt();

        final boolean IsNumber1HigherThanNumber2 = number1 >= number2;
        final boolean IsNumber2HigherThanNumber3 = number2 >= number3;
        final boolean IsNumber1HigherThanNumber3 = number1 >= number3;

        final int highestNumber;
        final int middleNumber;
        final int lowestNumber;
        
        if (IsNumber1HigherThanNumber2 && IsNumber2HigherThanNumber3) {
            highestNumber = number1;
            middleNumber = number2;
            lowestNumber = number3;
        } else if (IsNumber1HigherThanNumber2 && IsNumber1HigherThanNumber3) {
            highestNumber = number1;
            middleNumber = number3;
            lowestNumber = number2;
        } else if (IsNumber2HigherThanNumber3 && IsNumber1HigherThanNumber3) {
            highestNumber = number2;
            middleNumber = number1;
            lowestNumber = number3;
        } else if (IsNumber2HigherThanNumber3) {
            highestNumber = number2;
            middleNumber = number3;
            lowestNumber = number1;
        } else if (IsNumber1HigherThanNumber2) {
            highestNumber = number3;
            middleNumber = number1;
            lowestNumber = number2;
        } else {
            highestNumber = number3;
            middleNumber = number2;
            lowestNumber = number1;
        }

        System.out.println(lowestNumber + " " + middleNumber + " " + highestNumber);
    }
}