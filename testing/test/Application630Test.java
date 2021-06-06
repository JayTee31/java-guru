import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("In Application630")
public class Application630Test {

    @DisplayName("isThePlayerLosingAfterFirstRoll")
    @Nested
    public class IsThePlayerLosingAfterFirstRoll {

        @DisplayName("should throw an IllegalArgumentException if the argument is out of range")
        @ParameterizedTest
        @ValueSource(ints = {-10, 0, 1, 13, 30})
        public void shouldThrowIAEIfArgumentIsOutOfRange(final int roll) {
            // Expect
            assertThatIllegalArgumentException().isThrownBy(() -> {
                Application630.isThePlayerLosingAfterFirstRoll(roll);
            });
        }

        @DisplayName("should return true if the player is losing (rolling 2, 3 or 12")
        @ParameterizedTest
        @ValueSource(ints = {2, 3, 12})
        public void shouldReturnTrueIfThePlayerIsLosing(final int roll) {
            // When
            final boolean actual = Application630.isThePlayerLosingAfterFirstRoll(roll);

            // Then
            assertThat(actual).isTrue();
        }

        @DisplayName("should return false if the player not losing (not rolling 2, 3 or 12")
        @ParameterizedTest
        @ValueSource(ints = {4, 5, 6, 7, 8, 9, 10, 11})
        public void shouldReturnFalseIfThePlayerIsNotLosing(final int roll) {
            // When
            final boolean actual = Application630.isThePlayerLosingAfterFirstRoll(roll);

            // Then
            assertThat(actual).isFalse();
        }
    }

    @DisplayName("isThePlayerWinningAfterFirstRoll")
    @Nested
    public class IsThePlayerWinningAfterFirstRoll {

        @DisplayName("should throw an IllegalArgumentException if the argument is out of range")
        @ParameterizedTest
        @ValueSource(ints = {-10, 0, 1, 13, 30})
        public void shouldThrowIAEIfArgumentIsOutOfRange(final int roll) {
            // Expect
            assertThatIllegalArgumentException().isThrownBy(() -> {
                Application630.isThePlayerWinningAfterFirstRoll(roll);
            });
        }

        @DisplayName("should return true if the player is not losing (rolling 7 or 11")
        @ParameterizedTest
        @ValueSource(ints = {7, 11})
        public void shouldReturnTrueIfThePlayerIsWinning(final int roll) {
            // When
            final boolean actual = Application630.isThePlayerWinningAfterFirstRoll(roll);

            // Then
            assertThat(actual).isTrue();
        }

        @DisplayName("should return false if the player is not winning (not rolling 7 or 11")
        @ParameterizedTest
        @ValueSource(ints = {2, 3, 4, 5, 6, 8, 9, 10, 12})
        public void shouldReturnFalseIfThePlayerIsNotWinning(final int roll) {
            // When
            final boolean actual = Application630.isThePlayerWinningAfterFirstRoll(roll);

            // Then
            assertThat(actual).isFalse();
        }
    }

    @DisplayName("isThePlayerWinningAfterSecondRoll")
    @Nested
    public class IsThePlayerWinningAfterSecondRoll {

        @DisplayName("should return false if the input is seven.")
        @Test
        public void shouldReturnFalseIfInputIsSeven() {
            // Given
            final int roll = 7;

            // When
            final boolean actual = Application630.isThePlayerWinningAfterSecondRoll(roll);

            // Then
            assertThat(actual).isFalse();
        }

        @DisplayName("should return true if the input is other than seven.")
        @ParameterizedTest
        @ValueSource(ints = {2, 3, 4, 5, 6, 8, 9, 10, 11, 12})
        public void shouldReturnTrueIfInputIsOtherThanSeven(final int roll) {
            // When
            final boolean actual = Application630.isThePlayerWinningAfterSecondRoll(roll);

            // Then
            assertThat(actual).isTrue();
        }


    }



}