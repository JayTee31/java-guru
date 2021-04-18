import java.util.Scanner;

public class Solution318 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter the weight of the package in pounds");
        final double weight = input.nextDouble();

        double cost = 0;

        if (weight <= 0) {
            System.out.println("Enter a POSITIVE number, PLEASE");
        } else if (weight <= 2) {
            cost = 2.5;
        } else if (weight <= 4) {
            cost = 4.5;
        } else if (weight <= 10) {
            cost = 7.5;
        } else if (weight <= 20) {
            cost = 10.5;
        } else {
            System.out.println("The package cannot be shipped");
        }

        if (weight > 0 && weight <= 20) {
            System.out.println("The cost of the shipping is: " + cost + "$");
        }
    }
}