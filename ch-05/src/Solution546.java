import java.util.Scanner;

public class Solution546 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final String str = input.nextLine();
        String reverseStr = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            char charFromBack = str.charAt(i);
            reverseStr += charFromBack;
        }
        System.out.println(reverseStr);
    }
}
