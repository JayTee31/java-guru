import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("In Application, ")
public class ApplicationTest {
    @Nested
    @DisplayName("isPrime")
    class IsPrimeTest {
        @Test
        @DisplayName("should return false if the input is a negative number.")
        public void shouldReturnFalseIfInputIsNegative() {
            // Given
            final int number = -5;

            // When
            final boolean actual = Application.isPrime(number);

            // Then
            assertThat(actual).isFalse();
        }

        @Test
        @DisplayName("should return false if the input is equal to zero.")
        public void shouldReturnFalseIfInputIsZero() {
            // Given
            final int number = 0;

            // When
            final boolean actual = Application.isPrime(number);

            // Then
            assertThat(actual).isFalse();
        }

        @Test
        @DisplayName("should return false if the input is equal to one.")
        public void shouldReturnFalseIfInputIsOne() {
            // Given
            final int number = 1;

            // When
            final boolean actual = Application.isPrime(number);

            // Then
            assertThat(actual).isFalse();
        }

        @Test
        @DisplayName("should return true if the input is equal to two.")
        public void shouldReturnTrueIfInputIsTwo() {
            // Given
            final int number = 2;

            // When
            final boolean actual = Application.isPrime(number);

            // Then
            assertThat(actual).isTrue();
        }
    }
    
    @Nested
    @DisplayName("validateBounds")
    class ValidateBoundsTest {
        @Test
        @DisplayName("should return error if lower is greater than upper.")
        public void shouldReturnErrorIfLowerIsGreaterThanUpper() {
            // Given
            final int LOWER_BOUND = 5;
            final int UPPER_BOUND = 3;
            final String expected =
                    Application.THE_UPPER_BOUND_MUST_BE_GREATER_THAN_THE_LOWER_BOUND;

            // When
            final String actual = Application.validateBounds(LOWER_BOUND, UPPER_BOUND);

            // Then
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("should return error if lower is equal to upper.")
        public void shouldReturnErrorIfLowerIsEqualToUpper() {
            // Given
            final int LOWER_BOUND = 5;
            final int UPPER_BOUND = 5;
            final String expected =
                    Application.THE_UPPER_BOUND_MUST_BE_GREATER_THAN_THE_LOWER_BOUND;

            // When
            final String actual = Application.validateBounds(LOWER_BOUND, UPPER_BOUND);

            // Then
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("should return error if lower is less than two.")
        public void shouldReturnErrorIfLowerIsLessThanTwo() {
            // Given
            // Arrange
            final int LOWER_BOUND = 1;
            final int UPPER_BOUND = 3;
            final String expected =
                    Application.LOWER_BOUND_ERROR_CODE;

            // When
            // Act
            final String actual =
                    Application.validateBounds(LOWER_BOUND, UPPER_BOUND);

            // Then
            // Assert
            assertThat(actual).isEqualTo(expected);
        }


        @Test
        @DisplayName("should return success if the bounds are valid.")
        public void shouldReturnSuccessIfBoundsAreValid() {
            // Given
            final int LOWER_BOUND = 3;
            final int UPPER_BOUND = 27;
            final String expected = Application.VALIDATION_SUCCESS;

            // When
            final String actual = Application.validateBounds(LOWER_BOUND, UPPER_BOUND);

            // Then
            assertThat(actual).isEqualTo(expected);
        }

    }
}