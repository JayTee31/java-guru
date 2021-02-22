public class VariableScopes {
    public static void main(String[] args) {
        {
            double paff = 5.0;
            System.out.println(paff);
        }
        double paff = 6.0;
        System.out.println(paff);
    }
}