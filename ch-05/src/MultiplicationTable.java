public class MultiplicationTable {
    public static void main(String[] args) {

        System.out.print("    ");
        for (int x = 1; x < 10; x++) {
            System.out.printf("%4d", x);
        }
        System.out.println("\n" + "-".repeat(4 + 9 * 4));

        for (int i = 1; i < 10; i++) {
            System.out.printf("%d | ", i);
            for (int j = 1; j < 10; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
    }
}
