import java.util.concurrent.TimeUnit;

public class CurrentTime {
    public static void main(String[] args) throws Exception {
        final long SECS_IN_MS = 1000L;
        final long MINS_IN_MS = 60 * SECS_IN_MS;
        final long HOURS_IN_MS = 60 * MINS_IN_MS;
        final long DAYS_IN_MS = 24 * HOURS_IN_MS;

        while (true) {
            long start = System.nanoTime();
            // A maradék osztása 1 órának megfelelő miliszekundummal > ezzel megkapjuk az eltelt órák számát
            long remainingMilis = System.currentTimeMillis() % DAYS_IN_MS;
            final long hours = remainingMilis / HOURS_IN_MS;
            
            // Az ezutáni maradék osztása 1 percnek megfelelő milliszekundummal -> eltelt percek száma
            remainingMilis %= HOURS_IN_MS;
            final long mins = remainingMilis / MINS_IN_MS;
            
            // Az ezutáni maradék osztása 1 másodpercnek megfelelő milliszekundummal -> eltelt másodpercek száma
            remainingMilis %= MINS_IN_MS;
            final long secs = remainingMilis / SECS_IN_MS;
            
            // Eredmény kiírása
            System.out.println(hours + ":" + mins + ":" + secs);
            long finito = System.nanoTime();

            System.out.println(finito - start);
            TimeUnit.SECONDS.sleep(10);
        }
    }
}