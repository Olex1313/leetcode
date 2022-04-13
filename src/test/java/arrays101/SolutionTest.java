package arrays101;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("findMaxConsecutiveOnesProvider")
    void findMaxConsecutiveOnes(int[] nums, int expectedAnswer) {
        // given

        // when
        int actualAnswer = Solution.findMaxConsecutiveOnes(nums);

        // then
        assertEquals(actualAnswer, expectedAnswer);
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
}