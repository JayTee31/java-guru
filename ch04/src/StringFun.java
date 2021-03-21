import java.util.Scanner;

public class StringFun {
    public static void main(String[] args) {
        /* char ch = 'o';
        final String s = "Nagy\u0041pám1\b\b\b" + ch + " Plasz volt";
        System.out.println(s); */


        /* int i = '0';
        boolean b = 'c' > 'a';
        System.out.println(b); */

        /* final Scanner input = new Scanner(System.in);
        final char ch2 = input.nextLine().charAt(0);
        boolean isLetterLowercase = Character.isLowerCase(ch2);

        if (isLetterLowercase) {
            System.out.println(Character.toUpperCase(ch2));
        } else {
            System.out.println(Character.toLowerCase(ch2));
        } */

        /* final int MINIMUM_INT = Integer.MIN_VALUE;
        final char ch4 = (char)MINIMUM_INT;
        System.out.println(ch4); */

        /* char x = 'a';
        char y = 'c';
        System.out.println(++x);
        System.out.println(y++);
        System.out.println(x - y); */

        final int randomInt = (int)(Math.random() * ('z' - 'a') + 'a');
        // final char randomLowerCaseLetter = randomInt;
        System.out.println((char)('A' - 'a' + randomInt));
        System.out.println("😊");
    }
}
