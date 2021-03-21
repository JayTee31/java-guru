public class FormatDemo {
    public static void main(String[] args) {
        System.out.printf("%-10s%-10s%-10s%-10s%-10s\n", "Degrees", "Radians", "Sine", "Cosine", "Tangent");
        final int degrees = 30;
        final double radians = Math.toRadians(degrees);
        System.out.printf("%-10d%-10.4f%-10.4f%-10.4f%-10.4f\n", degrees, radians, Math.sin(radians), Math.cos(radians),
                Math.tan(radians));
        System.out.printf("%04d", 69);

        System.out.printf("%%");

        System.out.printf("%.2f\n%.3f\n", 1.23456, 2.34);
    }
}
