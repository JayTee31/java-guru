import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("In Application, ")
public class ApplicationTest {
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("formatNumbers")
    public class FormatNumbersTest {
        @Test
        @DisplayName("should return an empty String if the list is null.")
        public void shouldReturnEmptyStringIfTheListIsNull() {
            // Given
            final List<Integer> numbers = null;

            // When
            final String actual = Application.formatNumbers(numbers);

            // Then
            assertThat(actual).isEmpty();
        }

        @Test
        @DisplayName("should return an empty String if the list is empty.")
        public void shouldReturnEmptyStringIfTheListIsEmpty() {
            // Given
            final List<Integer> numbers = List.of();

            // When
            final String actual = Application.formatNumbers(numbers);

            // Then
            assertThat(actual).isEmpty();
        }

        @Test
        @DisplayName("should work correctly for a list which contains a single element.")
        public void shouldWorkCorrectlyForAListWithASingleElement() {
            // Given
            final List<Integer> numbers = List.of(10);
            final String expected = "10";

            // When
            final String actual = Application.formatNumbers(numbers);

            // Then
            assertThat(actual).isEqualTo(expected);
        }

        @ParameterizedTest
        @MethodSource("generateMultipleElementTestCases")
        @DisplayName("should work correctly for a list which contains multiple elements.")
        public void shouldWorkCorrectlyForAListWithMultipleElements(final List<Integer> numbers, final String expected) {
            // When
            final String actual = Application.formatNumbers(numbers);

            // Then
            assertThat(actual).isEqualTo(expected);
        }

        public List<Arguments> generateMultipleElementTestCases() {
            return List.of(
                    Arguments.of(List.of(1, 2, 3, 11, 101, 234, 1310, 0), "1, 2, 3, 11, 101, 234, 1310, 0"),
                    Arguments.of(List.of(10000000, 20000000, 11), "10000000, 20000000, 11"),
                    Arguments.of(List.of(-11, 0, 1, 99999999), "-11, 0, 1, 99999999")
            );
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
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

        @ParameterizedTest
        @MethodSource("compositeNumbers")
        @DisplayName("should return false if the input is composite.")
        public void shouldReturnFalseIfTheInputIsComposite(final int number) {
            // When
            final boolean actual = Application.isPrime(number);

            // Then
            assertThat(actual).isFalse();
        }

        public int[] compositeNumbers() {
            return new int[]{4, 6, 9, 15, 22, 33};
        }


        @ParameterizedTest
        @ValueSource(ints = {13, 31, 23, 97, 103})
        public void shouldReturnTrueIfInputIsPrime(final int number) {
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