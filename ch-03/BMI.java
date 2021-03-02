import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        final double POUND_TO_KG = 0.4535;
        final double INCH_TO_METER = 0.0254;
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter your weight (in pounds): ");
        final double weightInPounds = input.nextDouble();
        
        System.out.println("Enter your height (in inches): ");
        final double heightInInches = input.nextDouble();

        final double weightInKg = weightInPounds * POUND_TO_KG;
        final double heightInMeters = heightInInches * INCH_TO_METER;
        final double bmi = weightInKg / Math.pow(heightInMeters, 2);

        System.out.println("Your BMI " + bmi);

        if (bmi >= 30.0) {
            System.out.println("Obese");
        } else if (bmi >= 25.0) {
            System.out.println("Overwight");
        } else if (bmi >= 18.5) {
            System.out.println("Normal");
        } else {
            System.out.println("Underwight");
        }
    }
}