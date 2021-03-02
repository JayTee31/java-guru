import java.util.Scanner;

public class Exercise31 {
    public static void main(String[] args) {
        final double EPSILON = 0.0000001;
        final Scanner input = new Scanner(System.in);

        final double a = input.nextDouble();
        final double b = input.nextDouble();
        final double c = input.nextDouble();

        final double discriminant = Math.pow(b, 2) - (4 * a * c);
        final boolean isDiscriminantZero = Math.abs(discriminant) < EPSILON;
        
        if (isDiscriminantZero) {
            System.out.println("1 root");
            final double root1 = -b / (2 * a);
            System.out.println(root1);
        } else if (discriminant > 0) {
            System.out.println("2 root");
            final double root1 = (-b + Math.pow(discriminant, 0.5)) / (2 * a); 
            final double root2 = (-b - Math.pow(discriminant, 0.5)) / (2 * a);
            System.out.println("The 2 root is: " + root1 + " + " + root2);
        } else {
            System.out.println("No real root");
        }
    }
}