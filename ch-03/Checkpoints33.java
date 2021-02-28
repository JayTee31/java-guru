import java.util.Scanner;

public class Checkpoints33 {
    public static void main(String[] args) {
/*      final Scanner input = new Scanner(System.in);
        final int y = input.nextInt();
        int x = 1;
        if (y <= 0) {
            x = 2;
        }
        System.out.println(x); */
        
        
        
        final var input = new Scanner(System.in);
        final var score = input.nextInt();
        var pay = 1500.0;
        if (score > 90) {
            pay *= 1.03;
        } else {
            pay *= 1.01;
        }
        System.out.println(pay);
    }
}