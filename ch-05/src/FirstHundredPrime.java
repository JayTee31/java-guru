import java.util.Scanner;

public class FirstHundredPrime {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final int numberOfPrimes = input.nextInt();
        int n = 1;
        int howManyPrimesWeGot = 0;

        while (numberOfPrimes != howManyPrimesWeGot) {
            if (isPrime(n)) {
                System.out.println(n);
                howManyPrimesWeGot++;
            }
            n++;
        }
    }
    public static boolean isPrime(final int n) {
        if (n == 2) {
            return true;
        }
        if (n <= 1 || n % 2 == 0) {
            return false;
        }
        for (int i = 3; i < (n / 2); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}


// első x prím kell: minden egyes szám ellenőrzése, hogy prím-e, még x prímet nem kapunk (x = input)
// n = 1, y = 0 -tól indulunk
// Leellenőrízzük,
//      ha prím: kiírjuk, y változó, amihez minden alkalommal adunk 1-et amikor találtunk egy prímet
//      ha nem, akkor meg nem
// A futás addig tart, még y egyenlő lesz x-el
