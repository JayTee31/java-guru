import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final String str = input.nextLine();
        boolean isStrPalindrome = true;

        for (int i = 0; i <= str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                isStrPalindrome = false;
                break;
            }
        }
        System.out.println(isStrPalindrome);
    }

    public static boolean isStrPalindrome(String str) {
        if (str.length() == 0) {
            return true;
        }
        for (int i = 0; i <= str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}



// Bemenet > str = String
// Kimenet > boolean true / false

// Mitől palindrome a palindrome > előről és hátulról olvasva is ugyanaz, tehát:
//      aba -> palindrome > itt a középső (paráatlan) betűt nem kell összehasonlítani
//      abba -> palindrome

// összehasonlításnál a string első [i]karakterét hasonlítjuk az utolsóval [j] és így tovább, vagyis:
//      [i++] karakterét hasonlítjuk a [j--] karakterrel, a String hosszúságának a feléig length(n/2)
