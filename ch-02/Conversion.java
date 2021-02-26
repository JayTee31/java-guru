public class Conversion {
    public static void main(String[] args) {
        double d = 10 * 3;
        double dd = 3.14F;
        long l = 10;

        int i = (int)3.99;
        System.out.println(i);
        
        double j = (double)1 / 2;
        System.out.println(j);
        System.out.println("ceil : " + Math.ceil(j));
        System.out.println("floor : " + Math.floor(j));
        System.out.println("round : " + (double)Math.round(j));
        
        int k = (int)j;
        k += 3.14;
        // k = k + 3.14;
        k = (int)(k + 3.14);
        System.out.println(k);
    }
}