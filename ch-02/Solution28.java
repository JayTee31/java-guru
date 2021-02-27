import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Solution28 {
    public static void main(String[] args) throws Exception {
        final long SECS_IN_MS = 1000L;
        final long MINS_IN_MS = 60 * SECS_IN_MS;
        final long HOURS_IN_MS = 60 * MINS_IN_MS;
        final long DAYS_IN_MS = 24 * HOURS_IN_MS;

        final Scanner input = new Scanner(System.in);

        System.out.println("Enter the timezone offset to GMT: ");
        final long timezone = input.nextLong();


        // A maradék osztása 1 órának megfelelő miliszekundummal > ezzel megkapjuk az eltelt órák számát + kibővítve GMT-vel
        long remainingMilis = (System.currentTimeMillis() + timezone * HOURS_IN_MS) % DAYS_IN_MS;
        final long hours = remainingMilis / HOURS_IN_MS;
            
        // Az ezutáni maradék osztása 1 percnek megfelelő milliszekundummal -> eltelt percek száma
        remainingMilis %= HOURS_IN_MS;
        final long mins = remainingMilis / MINS_IN_MS;
            
        // Az ezutáni maradék osztása 1 másodpercnek megfelelő milliszekundummal -> eltelt másodpercek száma
        remainingMilis %= MINS_IN_MS;
        final long secs = remainingMilis / SECS_IN_MS;
            
        // Eredmény kiírása
        System.out.println(hours + ":" + mins + ":" + secs);
    }
}