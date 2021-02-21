import java.util.Scanner;

public class ComputeArea {
    public static void main(String[] args) {
        // 0. Get data
        final Scanner input = new Scanner(System.in);

        System.out.println("Írd be a magasságot:");
        final double height = input.nextDouble();
        
        System.out.println("Írd be a széleséget:");
        final double width = input.nextDouble();
        // 1. Calculate area
        final double area = height * width;
        // 2. Display
        System.out.println("Terület = " + area);
    }
}