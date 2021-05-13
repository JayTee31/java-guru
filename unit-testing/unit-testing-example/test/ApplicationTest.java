import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("In Application, ")
public class ApplicationTest {
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
    }
}