import java.util.Scanner;

public class StringShow {
    public static void main(String[] args) {
        /* final String message = "Welcome to Java";
        System.out.println(message.length());

        System.out.println(message.charAt(0) + " " + message.charAt(message.length() - 1));

        final String message2 = message.concat(", noob");

        System.out.println(message2);

        final String message3 = "Hojjoj ".concat(message);

        System.out.println(message3);

        final String stringTrim1 = "       Piff, anyukám!       ";
        final String stringTrim2 = stringTrim1.stripLeading()
                .toLowerCase()
                .repeat(3)
                .stripTrailing();

        System.out.println(stringTrim1);
        System.out.println(stringTrim2 + " paff"); */

        final Scanner input = new Scanner(System.in);
        final String wonder = input.next();
        // final String wall = input.next();

        // final String hopp = new String("Dinnye");
        // final String piffpaff = new String ("Dinnye");

        // System.out.println(wonder.equals(wall));

        // System.out.println(wonder.equalsIgnoreCase(wall));

        // System.out.println(wonder.compareTo(wall));
        // System.out.println(wall.compareTo(wonder));

        // System.out.println(hopp == piffpaff);

        // System.out.println(wonder.substring(1, wonder.length() - 1));

        // System.out.println(wonder.lastIndexOf("pizza"));

        if (wonder.lastIndexOf("pizza") >= 0) {
            System.out.println(wonder.substring(wonder.lastIndexOf("pizza") + "pizza".length()));
        } else {
            System.out.println("Nincs benne pizza");
        }

    }
}
