package arrays101;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeightCheckerTest {

    @ParameterizedTest
    @MethodSource("heightCheckerProvider")
    public void heightChecker(int[] arr, int expectedAnswer) {
        // given

        // when
        int givenAnswer = HeightChecker.heightChecker(arr);

        // then
        assertEquals(expectedAnswer, givenAnswer);
    }

    public static List<Arguments> heightCheckerProvider() {
        int[] firstCase = {1, 1, 4, 2, 1, 3};
        int[] secondCase = {5, 1, 2, 3, 4};
        int[] thirdCase = {1, 2, 3, 4, 5};
        return List.of(
                Arguments.of(firstCase, 3),
                Arguments.of(secondCase, 5),
                Arguments.of(thirdCase, 0)
        );
    }

}