import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("In Application618")
public class Application618Test {

    @DisplayName("isPasswordLongEnough")
    @Nested
    public class IsPasswordLongEnough {

        @DisplayName("should throw a NullPointerException if the input is null.")
        @Test
        public void shouldThrowNPEIfInputIsNull() {
            // Given
            final String password = null;

            // Expect
            assertThatNullPointerException().isThrownBy(() -> {
                Application618.isPasswordLongEnough(password);
            });
        }

        @DisplayName("should return false if the input's size is less than desired password length (10).")
        @ParameterizedTest
        @ValueSource(strings = {"", "1", "12345", "123456789"})
        public void shouldReturnFalseIfInputsSizeIsLessThanDesired(final String password) {
            // When
            final boolean actual = Application618.isPasswordLongEnough(password);

            // Then
            assertThat(actual).isFalse();
        }

        @DisplayName("should return true if the input's size is greater than or equal to desired password length (10).")
        @ParameterizedTest
        @ValueSource(strings = {"0123456789", "01234567891011"})
        public void shouldReturnTrueIfInputsSizeIsGreaterThanOrEqualToTen(final String password) {
            // When
            final boolean actual = Application618.isPasswordLongEnough(password);

            // Then
            assertThat(actual).isTrue();
        }
    }

    @DisplayName("isPasswordOnlyContainsLettersAndDigits")
    @Nested
    public class IsPasswordOnlyContainsLettersAndDigits {

        @DisplayName("should throw a NullPointerException if the input is null.")
        @Test
        public void shouldThrowNPEIfInputIsNull() {
            // Given
            final String password = null;

            // Expect
            assertThatNullPointerException().isThrownBy(() -> {
                Application618.isPasswordOnlyContainsLettersAndDigits(password);
            });
        }

        @DisplayName("should return false if the input contains other than digits and letters.")
        @ParameterizedTest
        @ValueSource(strings = {"", "~", "asdfga--GRSDG", "j 1s ", "j<>44ff", "Ł{}ee"})
        public void shouldReturnFalseIfInputContainsOtherThanDigitsAndLetters(final String password) {
            //When
            final boolean actual = Application618.isPasswordOnlyContainsLettersAndDigits(password);

            // Then
            assertThat(actual).isFalse();
        }

        @DisplayName("should return true if the input only contains digits and letters.")
        @ParameterizedTest
        @ValueSource(strings = {"1", "a", "234hb23hj", "JJJjjj222331100"})
        public void shouldReturnTrueIfInputOnlyContainsDigitsAndLetters(final String password) {
            //When
            final boolean actual = Application618.isPasswordOnlyContainsLettersAndDigits(password);

            // Then
            assertThat(actual).isTrue();
        }
    }

    @DisplayName("isPasswordContainsThreeDigits")
    @Nested
    public class IsPasswordContainsThreeDigits {

        @DisplayName("should throw a NullPointerException if the input is null.")
        @Test
        public void shouldThrowNPEIfInputIsNull() {
            // Given
            final String password = null;

            // Expect
            assertThatNullPointerException().isThrownBy(() -> {
                Application618.isPasswordContainsEnoughDigits(password);
            });
        }

        @DisplayName("should return false if input contains less digit than desired (3).")
        @ParameterizedTest
        @ValueSource(strings = {"", "asd", "1", "12"})
        public void shouldReturnFalseIfInputContainsLessDigitThanDesired(final String password) {
            // When
            final boolean actual = Application618.isPasswordContainsEnoughDigits(password);

            // Then
            assertThat(actual).isFalse();
        }

        @DisplayName("should return true if input contains equal or more digit than desired (3).")
        @ParameterizedTest
        @ValueSource(strings = {"123", "Paff123", "1645645", "dfdh111122233"})
        public void shouldReturnTrueIfInputContainsEnoughDigit(final String password) {
            // When
            final boolean actual = Application618.isPasswordContainsEnoughDigits(password);

            // Then
            assertThat(actual).isTrue();
        }
    }

    @DisplayName("passwordChecker")
    @Nested
    public class PasswordChecker {

        @DisplayName("should throw a NullPointerException if the input is null.")
        @Test
        public void shouldThrowNPEIfInputIsNull() {
            // Given
            final String password = null;

            // Expect
            assertThatNullPointerException().isThrownBy(() -> {
                Application618.passwordChecker(password);
            });
        }

        @DisplayName("should return true if the password is valid.")
        @ParameterizedTest
        @ValueSource(strings = {"aaaaaaaaaaa123", "7547457457845", "123456ggggggg"})
        public void shouldReturnTrueIfPasswordIsValid(final String password) {
            // When
            final boolean actual = Application618.passwordChecker(password);

            //Then
            assertThat(actual).isTrue();
        }

        @DisplayName("should return false if the password is invalid.")
        @ParameterizedTest
        @ValueSource(strings = {"123aaa", "srthiruhtuirth1", "123sfsdfsdfssf-----"})
        public void shouldReturnFalseIfPasswordIsInvalid(final String password) {
            // When
            final boolean actual = Application618.passwordChecker(password);

            //Then
            assertThat(actual).isFalse();
        }

    }




}