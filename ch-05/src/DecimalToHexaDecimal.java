import java.util.Scanner;

public class DecimalToHexaDecimal {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final int decimalNumber = input.nextInt();
        System.out.println(decaToHexa(decimalNumber));
    }

    public static String decaToHexa(int n) {
        int quotient = n;
        String hexaDecimalNumber = "";

        while (quotient > 0) {
            int nextDigit = quotient % 16;

            hexaDecimalNumber = hexaDigit(nextDigit) + hexaDecimalNumber;
            quotient /= 16;
        }
        return hexaDecimalNumber;
    }

    public static char hexaDigit(int n) {
        if (n > 9) {
            return (char)(n + 'A' - 10);
        }
        return (char)(n + '0');
    }
}


// Bevitel -> Scanner -> 10-es számrendszerben (int)
// Output -> a bevitt szám tizenhatos számrendszerben

// osztunk 16-al, maradék áll az utolsó helyiértéken ... így tovább amég osztható tovább (163 % 16 = 3 -> utolsó helyiérték,
// 163-ban a 16 megvan 10-szer azt osztjuk tovább 16-al és a maradékot megint leírjuk: 16-os számrendszerben a 10 = A, tehát:
// 163 = A3

// X = bemenet (int, 10-es számrendszer)
// addig osztunk 16-al, amég a hányados > 0
//      osztás -> maradék1 -> hányados tovább osztás - > maradék2
//      számunk= [maradékn]-[maradék2]-[maradék1]
//szám kiírása

