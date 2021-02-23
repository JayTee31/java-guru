import java.util.Scanner;

public class ComputeArea {
    public static void main(String[] args) {
        // 0. Get data
        final double PI = 3.14;
        final Scanner input = new Scanner(System.in);

        System.out.println("Írd be a kör sugarát");
        final double radius = input.nextDouble();
        
        // 1. Calculate area
        final double area = radius * radius * PI;
        // 2. Display
        System.out.println("Terület = " + area);
    }
}