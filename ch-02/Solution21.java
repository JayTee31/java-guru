import java.util.Scanner;

public class Solution21 {
    public static void main(String[] args) {
        final double MILE_TO_KM = 1.6;

        final Scanner input = new Scanner(System.in);
        
        System.out.println("Enter miles: ");
        final double miles = input.nextDouble();
        final double conversion = miles * MILE_TO_KM;
        System.out.println(miles + " miles is " + conversion + " kilometers");
    }
}