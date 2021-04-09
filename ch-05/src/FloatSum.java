public class FloatSum {
    public static void main(String[] args) {
        double sum = 0;

        for (double number = 0.01; number <= 1.0; number += 0.01) { // Pontatlan
            sum += number;
        }
        System.out.println(sum);
        sum = 0;
        double variable = 0.01;

        for (int intNumber = 0; intNumber < (int)(1.0 / 0.01); intNumber++) {
            sum += variable;
            variable += 0.01;
        }
        System.out.println(sum);
    }
}
