import java.util.Arrays;
import java.util.Scanner;

public class DeckOfCards {
    public static void main(String[] args) {
        final String[] NUMBERS = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9",
                "10", "Jack", "Queen", "King"};
        final String[] COLOURS = {"Hearts", "Spades", "Clubs", "Diamonds"};

        final Scanner input = new Scanner(System.in);
        final int numberOfCards = input.nextInt();
        
        final String[] finalBossDeck = shuffleDeck(createDeck(NUMBERS, COLOURS));

        for (int i = 0; i < numberOfCards; i++) {
            System.out.println(finalBossDeck[i]);
        }
    }

    public static String[] createDeck(final String[] numbers, final String[] colours) {
        final String[] deck = new String[numbers.length * colours.length];
        int k = 0;

        for (final String number : numbers) {
            for (final String colour : colours) {
                deck[k++] = String.format("%s of %s", number, colour);
            }
        }
        return deck;
    }

    public static String[] shuffleDeck(final String[] deck) {
        for (int i = 0; i < deck.length; i++) {
            final int j = (int)(Math.random() * deck.length);
            final String card = deck[i];
            deck[i] = deck[j];
            deck[j] = card;
        }
        return deck;
    }
}





// Mit akarunk: Pakli keverés - input: hány db kártyát kell kiírni a tetejéről
// 52 lapos francia kártya, kiírás szám of szín clubs, hearts, spades, diamonds


// Pakli generáló függvény -> 2 része lesz: szám és szín
    // - 52 db lap
    // - 4 féle szín
    // - 13 fajta szám
    // - 1 szám négy féle színben fordulhat elő
    // - Kiindulás Két tömb: szám a színt
    // - Return : 52 elemű tömb (strings)
    // szignatúra: public static String[] createDeck(String[] numbers, String[] colours)


// Keverő függvény -> megkeveri a lapokat random módon
    // Random.
    // szignatúra: public static String[] shuffleDeck(String[] deck)


// Húzó függvény n db (input)
