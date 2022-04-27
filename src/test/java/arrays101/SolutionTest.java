package arrays101;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("findMaxConsecutiveOnesProvider")
    void findMaxConsecutiveOnes(int[] nums, int expectedAnswer) {
        // given

        // when
        int actualAnswer = Solution.findMaxConsecutiveOnes(nums);

        // then
        assertEquals(expectedAnswer, actualAnswer);
    }

    @ParameterizedTest
    @MethodSource("findNumbersProvider")
    void findNumbers(int[] nums, int expectedAnswer) {
        // given

        // when
        int actualAnswer = Solution.findNumbers(nums);

        // then
        assertEquals(expectedAnswer, actualAnswer);
    }

    @ParameterizedTest
    @MethodSource("duplicateZeroesProvider")
    void duplicateZeroes(int[] givenArray, int[] expectedAnswer) {
        // given

        // when
        Solution.duplicateZeroes(givenArray);

        // then
        assertArrayEquals(expectedAnswer, givenArray);
    }

    @ParameterizedTest
    @MethodSource("removeElementProvider")
    void removeElement(int[] nums, int val, int[] expectedNums, int expectedAnswer) {
        // given

        // when
        int answer = Solution.removeElement(nums, val);

        // then
        assertEquals(expectedAnswer, answer);
        for(int i = 0; i < expectedAnswer; i++) {
            assertEquals(expectedNums[i], nums[i]);
        }
    }

    @ParameterizedTest
    @MethodSource("checkIfProvider")
    void checkIf(int[] arr, boolean expectedAnswer) {
        // given

        // when
        boolean actualAnswer = Solution.checkIf(arr);

        // then
        assertEquals(expectedAnswer, actualAnswer);
    }

    public static List<Arguments> findMaxConsecutiveOnesProvider() {
        int[] firstCase = {1, 1, 0, 1};
        int[] secondCase = {1, 0, 1, 1, 0, 1};
        int[] thirdCase = {1};
        int[] fourthCase = {0};
        int[] fifthCase = {1, 1, 0, 1, 1, 1};
        return List.of(
                Arguments.of(firstCase, 2),
                Arguments.of(secondCase, 2),
                Arguments.of(thirdCase, 1),
                Arguments.of(fourthCase, 0),
                Arguments.of(fifthCase, 3)
        );
    }

    public static List<Arguments> findNumbersProvider() {
        int[] firstCase = {12, 345, 2, 6, 7896};
        int[] secondCase = {};
        int[] thirdCase = {555, 901, 482, 1771};
        int[] fourthCase = {0};
        return List.of(
                Arguments.of(firstCase, 2),
                Arguments.of(secondCase, 0),
                Arguments.of(thirdCase, 1),
                Arguments.of(fourthCase, 1)
        );
    }

    public static List<Arguments> duplicateZeroesProvider() {
        int[] firstCase = {1, 0, 2, 3, 0, 4, 5, 0};
        int[] firstCaseAnswer = {1, 0, 0, 2, 3, 0, 0, 4};
        int[] secondCase = {1, 2, 3};
        int[] secondCaseAnswer = {1, 2, 3};
        int[] thirdCase = {0, 0, 0};
        int[] thirdCaseAnswer = {0, 0, 0};
        int[] fourthCase = {1, 0, 2};
        int[] fourthCaseAnswer = {1, 0, 0};
        int[] fifthCase = {0, 4, 1, 0, 0, 8, 0, 0, 3};
        int[] fifthCaseAnswer = {0, 0, 4, 1, 0, 0, 0, 0, 8};
        return List.of(
                Arguments.of(firstCase, firstCaseAnswer),
                Arguments.of(secondCase, secondCaseAnswer),
                Arguments.of(thirdCase, thirdCaseAnswer),
                Arguments.of(fourthCase, fourthCaseAnswer),
                Arguments.of(fifthCase, fifthCaseAnswer)
        );
    }

    public static List<Arguments> removeElementProvider() {
        int[] firstCase = {1, 0, 0, 2, 3};
        int[] firstCaseAnswer = {1, 2, 3, 0, 0};
        int[] secondCase = {1, 2, 3};
        int[] secondCaseAnswer = {1, 3, 3};
        return List.of(
                Arguments.of(firstCase, 0, firstCaseAnswer, 3),
                Arguments.of(secondCase, 2, secondCaseAnswer, 2)
        );
    }

    public static List<Arguments> checkIfProvider() {
        int[] firstCase = {10, 2, 5, 3};
        int[] secondCase = {7, 1, 14, 11};
        int[] thirdCase = {3, 1, 7, 11};
        int[] fourthCase = {0, 1};
        return List.of(
                Arguments.of(firstCase, true),
                Arguments.of(secondCase, true),
                Arguments.of(thirdCase, false),
                Arguments.of(fourthCase, false)
        );
    }

}