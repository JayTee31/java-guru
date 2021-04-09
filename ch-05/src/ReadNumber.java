import java.util.Scanner;

public class ReadNumber {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        System.out.println("Give me your phone number");
        String number;

        while (true) {
            try {
                number = input.nextLine();
                Integer.parseInt(number);
                break;
            } catch (Exception e) {
                System.out.println("Number format");
            }
        }
        System.out.println(number);
    }
}
