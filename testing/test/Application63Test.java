import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("In Application63, ")
public class Application63Test {

    @DisplayName("isPalindrome")
    @Nested
    public class IsPalindrome {

        @DisplayName("should return true if positive number has one digit.")
        @Test
        public void shouldReturnTrueIfPositiveNumberHasOneDigit() {
            // Given
            final int number = 5;

            // When
            final boolean actual = Application63.isPalindrome(number);

            // Then
            assertThat(actual).isTrue();
        }

        @DisplayName("should return true if negative number has one digit.")
        @Test
        public void shouldReturnTrueIfNegativeNumberHasOneDigit() {
            // Given
            final int number = -3;

            // When
            final boolean actual = Application63.isPalindrome(number);

            // Then
            assertThat(actual).isTrue();
        }


        @DisplayName("should return true if the number is a palindrome.")
        @ParameterizedTest
        @ValueSource(ints = {22, 12321, -989, 1234321, -44422444})
        public void shouldReturnTrueIfTheNumberIsPalindrome(final int number) {
            // When
            final boolean actual = Application63.isPalindrome(number);

            // Then
            assertThat(actual).isTrue();
        }

        @DisplayName("should return false if the number is not a palindrome.")
        @ParameterizedTest
        @ValueSource(ints = {223, 123214, -9819, 12343241, -444226444})
        public void shouldReturnFalseIfTheNumberIsNotPalindrome(final int number) {
            // When
            final boolean actual = Application63.isPalindrome(number);

            // Then
            assertThat(actual).isFalse();
        }

    }



}