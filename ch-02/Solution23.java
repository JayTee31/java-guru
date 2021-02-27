import java.util.Scanner;

public class Solution23 {
    public static void main(String[] args) {
        final double METER_TO_FEET = 3.2786;

        final Scanner input = new Scanner(System.in);

        System.out.println("Enter a value for meter: ");
        final double meter = input.nextDouble();
        final double feet = meter * METER_TO_FEET;
        
        System.out.println(meter + " meters is " + feet + " feet ");
    }
}