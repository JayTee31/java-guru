public class Checkpoints310 {
    public static void main(String[] args) {
        int num = 10;
        boolean b = 1 < num && num < 100;

        b = (1 < num && num < 100) || num < 0;

        double x = 9.9999;
        boolean c = Math.abs(x - 5) < 4.5; 


        double weight = 100;
        double height = 200;

        boolean z = weight > 50 || height > 60;
        boolean paff = weight > 50 && height > 60;
        boolean pfej = weight > 60 ^ height > 60;
    }
}