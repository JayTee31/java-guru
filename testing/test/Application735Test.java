import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("In Application735")
public class Application735Test {

    @DisplayName("isWordContainsGuess")
    @Nested
    public class IsWordContainsGuess {

        @DisplayName("should return true if the word contains the guess.")
        @ParameterizedTest
        @MethodSource("generateTestCasesForWordContainsGuess")
        public void shouldReturnTrueIfWordContainsGuess(final char[] word, final char guess) {

        }

        public List<Arguments> generateTestCasesForWordContainsGuess() {
            return List.of(
                    Arguments.of(new char[]{'a', 'l', 'm', 'a'}, 'a'),
                    Arguments.of(new char[]{'p', 'a', '-', 'f'}, '-'),
                    Arguments.of(new char[]{'1', '*', 's', '2'}, '1')
            );
        }

    }

}