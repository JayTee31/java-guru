public class Solution510 {
    public static void main(String[] args) {
        int loopActivationCounter = 0;

        for (int i = 100; i <= 1000; i++) {
            if (i % 3 == 0 && i % 4 == 0) {
                System.out.printf("%d ", i);
                loopActivationCounter++;
            }
            if (loopActivationCounter % 10 == 0 && loopActivationCounter != 0) {
                System.out.println();
                loopActivationCounter = 0;
            }
        }
    }
}
