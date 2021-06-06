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


@DisplayName("In Application731")
public class Application731Test {

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("mergeLists")
    @Nested
    public class MergeLists {

        @DisplayName("should throw a NullPointerException if the first argument is null.")
        @Test
        public void shouldThrowNPEIfFirstArgumentIsNull() {
            // Given
            final int[] list1 = null;
            final int[] list2 = {1, 2, 3};

            // Expected
            assertThatNullPointerException().isThrownBy(() -> {
                Application731.mergeLists(list1, list2);
            });
        }

        @DisplayName("should throw a NullPointerException if the second argument is null.")
        @Test
        public void shouldThrowNPEIfSecondArgumentIsNull() {
            // Given
            final int[] list1 = {1, 2, 3};
            final int[] list2 = null;

            // Expected
            assertThatNullPointerException().isThrownBy(() -> {
                Application731.mergeLists(list1, list2);
            });
        }


        @DisplayName("should throw a NullPointerException if both of the arguments are null.")
        @Test
        public void shouldThrowNPEIfBothArgumentsAreNull() {
            // Given
            final int[] list1 = null;
            final int[] list2 = null;

            // Expected
            assertThatNullPointerException().isThrownBy(() -> {
                Application731.mergeLists(list1, list2);
            });
        }

        @DisplayName("should throw an IllegalArgumentException if the first argument is an empty array.")
        @Test
        public void shouldThrowIAEIfFirstArgumentIsAnEmptyArray() {
            // Given
            final int[] list1 = {};
            final int[] list2 = {3, 4, 5};

            // Expect
            assertThatIllegalArgumentException().isThrownBy(() -> {
                Application731.mergeLists(list1, list2);
            });
        }

        @DisplayName("should throw an IllegalArgumentException if the second argument is an empty array.")
        @Test
        public void shouldThrowIAEIfSecondArgumentIsAnEmptyArray() {
            // Given
            final int[] list1 = {4, 5, 6};
            final int[] list2 = {};

            // Expected
            assertThatIllegalArgumentException().isThrownBy(() -> {
                Application731.mergeLists(list1, list2);
            });
        }

        @DisplayName("should throw an IllegalArgumentException if both arguments are empty arrays.")
        @Test
        public void shouldThrowIAEIfBothArgumentsAreEmptyArrays() {
            // Given
            final int[] list1 = {};
            final int[] list2 = {};

            // Expected
            assertThatIllegalArgumentException().isThrownBy(() -> {
                Application731.mergeLists(list1, list2);
            });
        }

        @DisplayName("should work correctly, if arguments are singleton arrays.")
        @ParameterizedTest
        @MethodSource("generateTestCasesForSingletonArrayArguments")
        public void shouldWorkCorrectlyIfArgumentIsASingletonArray(final int[] list1, final int[] list2, final int[] expected) {
            // When
            final int[] actual = Application731.mergeLists(list1, list2);

            // Then
            assertThat(actual).isEqualTo(expected);
        }

        public List<Arguments> generateTestCasesForSingletonArrayArguments() {
            return List.of(
                    Arguments.of(new int[]{3}, new int[]{1, 2, 3, 9}, new int[]{1, 2, 3, 3, 9}),
                    Arguments.of(new int[]{4, 8, 10}, new int[]{6}, new int[]{4, 6, 8, 10}),
                    Arguments.of(new int[]{5}, new int[]{6}, new int[]{5,6})
            );
        }

        @DisplayName("should work correctly if the first argument has smaller size.")
        @Test
        public void shouldWorkCorrectlyIfFirstArgumentHasSmallerSize() {
            // Given
            final int[] list1 = {2, 4, 5};
            final int[] list2 = {1, 4, 6, 10, 30};
            final int[] expected = {1, 2, 4, 4, 5, 6, 10, 30};

            // When
            final int[] actual = Application731.mergeLists(list1, list2);

            // Then
            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("should work correctly if the second argument has smaller size.")
        @Test
        public void shouldWorkCorrectlyIfSecondArgumentHasSmallerSize() {
            // Given
            final int[] list1 = {0, 5, 6, 10, 43};
            final int[] list2 = {1, 4, 9, 21};
            final int[] expected = {0, 1, 4, 5, 6, 9, 10, 21, 43};

            // When
            final int[] actual = Application731.mergeLists(list1, list2);

            // Then
            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("should work correctly if the arguments have the same size.")
        @ParameterizedTest
        @MethodSource("generateTestCasesForSameSizeArrayArguments")
        public void shouldWorkCorrectlyIfArgumentsHaveTheSameSize(final int[] list1, final int[] list2, final int[] expected) {
            // When
            final int[] actual = Application731.mergeLists(list1, list2);

            // Then
            assertThat(actual).isEqualTo(expected);
        }

        public List<Arguments> generateTestCasesForSameSizeArrayArguments() {
            return List.of(
                    Arguments.of(new int[]{3}, new int[]{6}, new int[]{3, 6}),
                    Arguments.of(new int[]{4, 8, 10}, new int[]{6, 10, 20}, new int[]{4, 6, 8, 10, 10, 20}),
                    Arguments.of(new int[]{3, 5, 6, 7}, new int[]{3, 4, 6, 10}, new int[]{3, 3, 4, 5, 6, 6, 7, 10})
            );
        }

        @DisplayName("should work correctly with negative inputs.")
        @ParameterizedTest
        @MethodSource("generateTestCasesForNegativeInputs")
        public void shouldWorkCorrectlyWithNegativeInputs(final int[] list1, final int[] list2, final int[] expected) {
            // When
            final int[] actual = Application731.mergeLists(list1, list2);

            // Then
            assertThat(actual).isEqualTo(expected);
        }

        public List<Arguments> generateTestCasesForNegativeInputs() {
            return List.of(
                    Arguments.of(new int[]{-30, -22, -5}, new int[]{0, 2, 4, 5}, new int[]{-30, -22, -5, 0, 2, 4, 5}),
                    Arguments.of(new int[]{3, 4, 10, 44}, new int[]{-10, -6, -3}, new int[]{-10, -6, -3, 3, 4, 10, 44}),
                    Arguments.of(new int[]{-11, -8, -5}, new int[]{-21, -16, -7, -4}, new int[]{-21, -16, -11, -8, -7, -5, -4})
            );
        }

        @DisplayName("should work correctly if the smaller sized argument has higher values.")
        @ParameterizedTest
        @MethodSource("generateTestCasesForSmallerSizedArgumentsWithHigherValues")
        public void shouldWorkCorrectlyIfSmallerSizedArgumentHasHigherValues(final int[] list1, final int[] list2, final int[] expected) {
            // When
            final int[] actual = Application731.mergeLists(list1, list2);

            // Then
            assertThat(actual).isEqualTo(expected);
        }

        public List<Arguments> generateTestCasesForSmallerSizedArgumentsWithHigherValues() {
            return List.of(
                    Arguments.of(new int[]{1, 100, 300}, new int[]{2, 3, 5, 6, 7}, new int[]{1, 2, 3, 5, 6, 7, 100, 300}),
                    Arguments.of(new int[]{4, 6, 7, 10}, new int[]{5, 222, 333}, new int[]{4, 5, 6, 7, 10, 222, 333})
            );
        }

        @DisplayName("should work correctly if the smaller sized argument has lower values.")
        @ParameterizedTest
        @MethodSource("generateTestCasesForSmallerSizedArgumentsWithLowerValues")
        public void shouldWorkCorrectlyIfSmallerSizedArgumentHasLowerValues(final int[] list1, final int[] list2, final int[] expected) {
            // When
            final int[] actual = Application731.mergeLists(list1, list2);

            // Then
            assertThat(actual).isEqualTo(expected);
        }

        public List<Arguments> generateTestCasesForSmallerSizedArgumentsWithLowerValues() {
            return List.of(
                    Arguments.of(new int[]{1, 5, 6}, new int[]{4, 111, 124, 345, 422}, new int[]{1, 4, 5, 6, 111, 124, 345, 422}),
                    Arguments.of(new int[]{11, 67, 90, 212}, new int[]{6, 16}, new int[]{6, 11, 16, 67, 90, 212})
            );
        }

        @DisplayName("should work correctly if both arguments contains same values.")
        @Test
        public void shouldWorkCorrectlyIfArgumentsContainsSameValues() {
            // Given
            final int[] list1 = {1, 2, 3, 4, 5};
            final int[] list2 = {1, 2, 3, 4, 5};
            final int[] expected = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};

            // When
            final int[] actual = Application731.mergeLists(list1, list2);

            // Then
            assertThat(actual).isEqualTo(expected);
        }
    }
}