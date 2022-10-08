package arrays101;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("findMaxConsecutiveOnesProvider")
    public void findMaxConsecutiveOnes(int[] nums, int expectedAnswer) {
        // given

        // when
        int actualAnswer = Solution.findMaxConsecutiveOnes(nums);

        // then
        assertEquals(expectedAnswer, actualAnswer);
    }

    @ParameterizedTest
    @MethodSource("findNumbersProvider")
    public void findNumbers(int[] nums, int expectedAnswer) {
        // given

        // when
        int actualAnswer = Solution.findNumbers(nums);

        // then
        assertEquals(expectedAnswer, actualAnswer);
    }

    @ParameterizedTest
    @MethodSource("duplicateZeroesProvider")
    public void duplicateZeroes(int[] givenArray, int[] expectedAnswer) {
        // given

        // when
        Solution.duplicateZeroes(givenArray);

        // then
        assertArrayEquals(expectedAnswer, givenArray);
    }

    @ParameterizedTest
    @MethodSource("removeElementProvider")
    public void removeElement(int[] nums, int val, int[] expectedNums, int expectedAnswer) {
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
    public void checkIf(int[] arr, boolean expectedAnswer) {
        // given

        // when
        boolean actualAnswer = Solution.checkIf(arr);

        // then
        assertEquals(expectedAnswer, actualAnswer);
    }

    @ParameterizedTest
    @MethodSource("validMountainArrayProvider")
    public void validMountainArray(int[] arr, boolean expectedAnswer) {
        // given

        // when
        boolean actualAnswer = Solution.validMountainArray(arr);

        // then
        assertEquals(expectedAnswer, actualAnswer);
    }

    @ParameterizedTest
    @MethodSource("sortedSquaresProvider")
    public void sortedSquares(int[] nums, int[] expectedAnswer) {
        // given

        // when
        int[] answer = Solution.sortedSquares(nums);

        // then
        assertArrayEquals(expectedAnswer, answer);
    }

    @ParameterizedTest
    @MethodSource("replaceElementsProvider")
    public void replaceElementsTest(int[] arr, int[] expectedAnswer) {
        // given

        // when
        int[] actualAnswer = Solution.replaceElements(arr);

        // then
        assertArrayEquals(expectedAnswer, actualAnswer);
    }

    @ParameterizedTest
    @MethodSource("removeDuplicatesProvider")
    public void removeDuplicatesTest(int[] arr, int[] expectedArr) {
        // given

        // when
        int k = Solution.removeDuplicates(arr);

        // then
        assertEquals(expectedArr.length, k);
        for(int i = 0; i < k; i++) {
            assertEquals(arr[i], expectedArr[i]);
        }
    }

    @ParameterizedTest
    @MethodSource("moveZeroesProvider")
    public void moveZeroes(int[] arr, int[] expectedArr) {
        // given

        // when
        Solution.moveZeroes(arr);

        // then
        assertArrayEquals(expectedArr, arr);
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

    public static List<Arguments> validMountainArrayProvider() {
        int[] firstCase = {2, 5, 10, 3};
        int[] secondCase = {7, 1, 14, 11};
        int[] thirdCase = {1, 1, 11, 7};
        int[] fourthCase = {0, 1};
        return List.of(
                Arguments.of(firstCase, true),
                Arguments.of(secondCase, false),
                Arguments.of(thirdCase, false),
                Arguments.of(fourthCase, false)
        );
    }

    public static List<Arguments> sortedSquaresProvider() {
        int[] firstCase = {-5, -2, 3, 10};
        int[] firstCaseAnswer = {4, 9, 25, 100};
        int[] secondCase = {-7, 0, 11, 14};
        int[] secondCaseAnswer = {0, 49, 121, 196};
        int[] thirdCase = {-1, 1, 7,11};
        int[] thirdCaseAnswer = {1, 1, 49, 121};
        int[] fourthCase = {0, 1};
        int[] fourthCaseAnswer = {0, 1};
        return List.of(
                Arguments.of(firstCase, firstCaseAnswer),
                Arguments.of(secondCase, secondCaseAnswer),
                Arguments.of(thirdCase, thirdCaseAnswer),
                Arguments.of(fourthCase, fourthCaseAnswer)
        );
    }

    public static List<Arguments> replaceElementsProvider() {
        int[] firstCase = {-5, -2, 3, 10};
        int[] firstCaseAnswer = {10, 10, 10, -1};
        int[] secondCase = {-7, 0, 11, 14};
        int[] secondCaseAnswer = {14, 14, 14, -1};
        int[] thirdCase = {-1, 1, 7, 1};
        int[] thirdCaseAnswer = {7, 7, 1, -1};
        int[] fourthCase = {0, 1};
        int[] fourthCaseAnswer = {1, -1};
        return List.of(
                Arguments.of(firstCase, firstCaseAnswer),
                Arguments.of(secondCase, secondCaseAnswer),
                Arguments.of(thirdCase, thirdCaseAnswer),
                Arguments.of(fourthCase, fourthCaseAnswer)
        );
    }

    public static List<Arguments> removeDuplicatesProvider() {
        int[] firstCase = {-5, -5, 1, 1};
        int[] firstCaseAnswer = {-5, 1};
        int[] secondCase = {1, 1, 1, 1};
        int[] secondCaseAnswer = {1};
        int[] thirdCase = {-1, 1, 2, 2};
        int[] thirdCaseAnswer = {-1, 1, 2};
        int[] fourthCase = {1, 1, 2, 3, 4, 4, 4};
        int[] fourthCaseAnswer = {1, 2, 3, 4};
        return List.of(
                Arguments.of(firstCase, firstCaseAnswer),
                Arguments.of(secondCase, secondCaseAnswer),
                Arguments.of(thirdCase, thirdCaseAnswer),
                Arguments.of(fourthCase, fourthCaseAnswer)
        );
    }

    public static List<Arguments> moveZeroesProvider() {
        int[] firstCase = {0, 0, 1, 1};
        int[] firstCaseAnswer = {1, 1, 0, 0};
        int[] secondCase = {0, 0, 0};
        int[] secondCaseAnswer = {0, 0, 0};
        int[] thirdCase = {-1, 0, 2, 2};
        int[] thirdCaseAnswer = {-1, 2, 2, 0};
        int[] fourthCase = {1, 2, 3, 4};
        int[] fourthCaseAnswer = {1, 2, 3, 4};
        return List.of(
                Arguments.of(firstCase, firstCaseAnswer),
                Arguments.of(secondCase, secondCaseAnswer),
                Arguments.of(thirdCase, thirdCaseAnswer),
                Arguments.of(fourthCase, fourthCaseAnswer)
        );
    }

}