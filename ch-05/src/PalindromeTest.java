import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {
    @Test
    public void emptyStringsArePalindromes() {
        // Given
        String str = "";
        boolean expected = true;

        // When
        boolean actual = Palindrome.isStrPalindrome(str);

        // Then
        assertSame(expected, actual);
    }

    @Test
    public void areSpecialCharactersPalindromes() {
        // Given
        String str = "    ";
        boolean expected = true;

        // When
        boolean actual = Palindrome.isStrPalindrome(str);

        // Then
        assertSame(expected, actual);
    }

}