import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("In Application76")
public class Application76Test {

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("listOfPrimes")
    @Nested
    public class ListOfPrimes {

        @DisplayName("should throw an IllegalArgumentException if the input is lower than two.")
        @ParameterizedTest
        @ValueSource(ints = {-5, 0, 1})
        public void shouldThrowIAEIfTheInputIsLowerThanTwo(final int number) {
            // Expect
            assertThatIllegalArgumentException().isThrownBy(() -> {
                Application76.listOfPrimes(number);
            });
        }

        @DisplayName("should work correctly.")
        @ParameterizedTest
        @MethodSource("generateTestCases")
        public void shouldWorkCorrectly(final int number, final List<Integer> expected) {
            // When
            final List<Integer> actual = Application76.listOfPrimes(number);

            // Then
            assertThat(actual).isEqualTo(expected);
        }

        public List<Arguments> generateTestCases() {
            return List.of(
                    Arguments.of(2, List.of(2)),
                    Arguments.of(10, List.of(2, 3, 5, 7)),
                    Arguments.of(20, List.of(2, 3, 5, 7, 11, 13, 17, 19))
                    );
        }
    }
}