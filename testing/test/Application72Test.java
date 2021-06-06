import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("In Application72")
public class Application72Test {

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("compareToTheLastElement")
    @Nested
    public class CompareToTheLastElement {

        @DisplayName("should throw a NullPointerException if the input is null.")
        @Test
        public void shouldThrowNPEIfTheInputIsNull() {
            // Given
            final int[] numbers = null;

            // Expect
            assertThatThrownBy(() -> {
                Application72.compareToTheLastElement(numbers);
            }).isInstanceOf(NullPointerException.class);

            assertThatNullPointerException().isThrownBy(() -> {
                Application72.compareToTheLastElement(numbers);
            });
        }

        @DisplayName("should throw IllegalArgumentException if the input is an empty array.")
        @Test
        public void shouldThrowIAEIfTheInputIsAnEmptyArray() {
            // Given
            final int[] numbers = {};

            // Expect
            assertThatIllegalArgumentException().isThrownBy(() -> {
                Application72.compareToTheLastElement(numbers);
            });
        }

        @DisplayName("should throw IllegalArgumentException if the input is a singleton array.")
        @Test
        public void shouldThrowIAEIfTheInputIsASingletonArray() {
            // Given
            final int[] numbers = {5};

            // Expect
            assertThatThrownBy(() -> {
                Application72.compareToTheLastElement(numbers);
            }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("pisztácia");
        }

        @DisplayName("should work correctly.")
        @ParameterizedTest
        @MethodSource("generateTestCases")
        public void shouldWorkCorrectly(final int[] numbers, final String[] expected) {
            // When
            final String[] actual = Application72.compareToTheLastElement(numbers);

            // Then
            assertThat(actual).isEqualTo(expected);
        }

        public List<Arguments> generateTestCases() {
            return List.of(
                    Arguments.of(new int[]{1, 5, 10, 5}, new String[]{Application72.SMALLER, Application72.EQUAL,
                        Application72.GREATER}),
                    Arguments.of(new int[]{1, 1, 1, 1}, new String[]{Application72.EQUAL, Application72.EQUAL,
                            Application72.EQUAL}),
                    Arguments.of(new int[]{2, 6}, new String[]{Application72.SMALLER})
            );
        }
    }
}