public class Solution53 {
    public static void main(String[] args) {
        System.out.println("Celsius      Fahrenheit");
        final int howManySpacesINeed = "Celsius      Fahrenheit".length();

        for (int celsius = 0; celsius <= 100; celsius += 2) {
            double fahrenheit = celsius * (9.0 / 5.0) + 32;

            double fahrenheitWithOneDecimal = (int)(fahrenheit * 10) / 10.0;
            String celsiusInString = String.valueOf(celsius);
            String fahrenheitInString = String.valueOf(fahrenheitWithOneDecimal);

            System.out.printf("%d", celsius);
            System.out.printf("%s%.1f", " ".repeat(howManySpacesINeed - celsiusInString.length() - fahrenheitInString.length()),
                    fahrenheit);
            System.out.println();
        }
    }
}
