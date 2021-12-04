package stringfromhashcode;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import static java.util.Objects.hash;

public class StringFromHashCode {
    /*public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        int piff = 0;
        int paff = 0;
        final int a = -290305467;
        final int b = 114801;
        final int c = 96891675;
        final int d = -795499759;
        final int e = -25407024;

        for (int i = 0; i < 6; i ++) {
            piff += Math.pow(31, i);
        }

        for (int i = 0; i < 5; i++) {
            paff += Math.pow(31, i);
        }

        System.out.println("aaaaaa".hashCode());
        System.out.println(piff * 'a');
        System.out.println("aaaaa".hashCode());
        System.out.println("aaaaaa".hashCode() - 'a' * (int)Math.pow(31, 5));
        System.out.println(convertStringFromHash(b, b, str, 1));



    }

    public static String convertStringFromHash(final int hashcode, final int originalHashcode, final StringBuilder str, int lengthOfWord) {
        int divider = getDividerValue(lengthOfWord);
        int character = 0;
        boolean appendHappened = false;

        for (int i = 'a'; i <= 'z'; i++) {
            int asdasd = divider * i;
            if (divider * i == hashcode) {
                character = i;
                str.append((char)i);
                appendHappened = true;
                break;
            }
        }

        if (appendHappened) {
            if (lengthOfWord >= 1) {
                convertStringFromHash(hashcode - character * (int)Math.pow(31, lengthOfWord), originalHashcode, str, lengthOfWord - 1);
            }
        } else {
            if (str.length() != 0) {
                final int lengthOfStr = str.length();
                str.delete(0, str.length());
                convertStringFromHash(originalHashcode, originalHashcode, str, lengthOfStr + 1);
            } else {
                convertStringFromHash(hashcode, originalHashcode, str, lengthOfWord + 1);
            }
        }


        return str.toString();
    }

    public static int getDividerValue(final int lengthOfWord) {
        int divider = 0;

        for (int i = 0; i < lengthOfWord; i++) {
            divider += Math.pow(31, i);
        }

        return divider;
    }

    public static boolean isSmallLetter(final long number) {
        return number>= 'a' && number <= 'z';
    }




    StringBuilder str = new StringBuilder();
    BigDecimal bigdecimal = new BigDecimal(0);
    final int a = 114801;
    final int b = 3370;


        System.out.println(stringFromHashcode(a, str, bigdecimal));
        System.out.println(stringFromHashcode(b, str, bigdecimal));



}




    public static StringBuilder stringFromHashcode(final int hashcode, final StringBuilder str, BigDecimal compensationValue) {
        BigDecimal number;
        int lengthOfWord = 0;

        if (hashcode < 0) {
            number = new BigDecimal(Math.abs(Integer.MIN_VALUE) - Math.abs(hashcode));
            number = number.add(compensationValue);
        } else {
            number = new BigDecimal(hashcode);
            number = number.add(compensationValue);
        }

        int i = 0;

        while (true) {
            int divider = 0;

            for (int j = 0; j <= i; j++) {
                divider += Math.pow(31, j);
            }

            double afterDivide = number.divide(new BigDecimal(divider + ""), 0, RoundingMode.HALF_DOWN).doubleValue();


            if (afterDivide <= 'z' && afterDivide >= 'a') {
                str.append((char)afterDivide);

                if (i == 0) {
                    break;
                }

                stringFromHashcode((int)(hashcode - afterDivide * Math.pow(31, i)), str, compensationValue);
                break;
            } else if (afterDivide < 'a'){
                if (compensationValue.equals(BigDecimal.valueOf(Math.pow(31, i + 1)))) {
                    compensationValue = compensationValue.add(BigDecimal.valueOf(Math.pow(31, i + 2)));
                } else {
                    compensationValue = compensationValue.add(BigDecimal.valueOf(Math.pow(31, i + 1)));
                }
                stringFromHashcode(hashcode, str, compensationValue);
            }



            i++;
        }

        return str;
    }

    public static boolean isOnlySmallLetters(final String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < 'a' || str.charAt(i) > 'z') {
                return false;
            }
        }

        return true;
    } */
}
