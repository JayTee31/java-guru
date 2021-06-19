import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("In Application735")
public class Application735Test {

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("isWordContainsGuess")
    @Nested
    public class IsWordContainsGuess {

        @DisplayName("should return true if the word contains the guess.")
        @ParameterizedTest
        @MethodSource("generateTestCasesForWordContainsGuess")
        public void shouldReturnTrueIfWordContainsGuess(final char[] word, final char guess) {
            // When
            final boolean actual = Application735.isWordContainsGuess(word, guess);

            // Then
            assertThat(actual).isTrue();
        }

        public List<Arguments> generateTestCasesForWordContainsGuess() {
            return List.of(
                    Arguments.of(new char[]{'a', 'l', 'm', 'a'}, 'a'),
                    Arguments.of(new char[]{'p', 'a', '-', 'f'}, '-'),
                    Arguments.of(new char[]{'1', '*', 's', '2'}, '1')
            );
        }

        @DisplayName("should return false if the word does not contain the guess.")
        @ParameterizedTest
        @MethodSource("generateTestCasesForWordDoesNotContainGuess")
        public void shouldReturnFalseIfWordDoesNotContainsGuess(final char[] word, final char guess) {
            // When
            final boolean actual = Application735.isWordContainsGuess(word, guess);

            // Then
            assertThat(actual).isFalse();
        }

        public List<Arguments> generateTestCasesForWordDoesNotContainGuess() {
            return List.of(
                    Arguments.of(new char[]{'p', 'l', 'f', 'a'}, '1'),
                    Arguments.of(new char[]{'u', 'a', '*', 'd'}, 'p'),
                    Arguments.of(new char[]{'6', '*', 'z', 't'}, '-')
            );
        }

    }

}