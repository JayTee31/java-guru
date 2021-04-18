public class Solution525 {
    public static void main(String[] args) {
        double piValue = 0;
        int signChanger = 1;

        for (int i = 10000; i <= 100000; i += 10000) {
            for (int j = 1; j <= i; j++) {
                double quotient = 1.0 / (2 * j - 1);
                piValue += (signChanger * quotient);
                signChanger *= -1;
            }
            System.out.println(piValue * 4);
            piValue = 0;
        }
    }
}
