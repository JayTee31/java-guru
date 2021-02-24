public class Modulo {
    public static void main(String[] args) {
        System.out.println(56 % 6);
        System.out.println(78 % -4);
        System.out.println(-34 % 5);
        System.out.println(-34 % -5);
        System.out.println(5 % 1);
        System.out.println(1 % 5);
        System.out.println(((2 * 5) / 2) + ((2 * 5) / 2));
        System.out.println(25 / 4.0);
        System.out.println("Hopphopp " + 3.0 * 2 / 4);

        int r = 2;
        int m = 5;
        System.out.println(m * r * r);

        System.out.println(0b100111001101010100111001);
        System.out.println(07635235L);
        System.out.println(0xCAFEBABEL);  // 242. page -> why is it negative
        System.out.println(1_000_000); 
        System.out.println(1_1e+0); 
    }
}