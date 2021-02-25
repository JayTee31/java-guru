import java.util.concurrent.TimeUnit;

public class Increment {
    public static void main(String[] args) throws Exception {
        int counter = 0;
        int a = ++counter;
        int b = 5 * counter++ * ++counter;
        System.out.println(b);
        System.out.println(counter);
        int c = counter--;
        int d = --counter;
    }
}