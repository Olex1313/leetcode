package arrays101;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortArrayByParityTest {

    @ParameterizedTest
    @MethodSource("sortArrayByParityProvider")
    void sortArrayByParity(int[] arr, int[] expectedArr) {
        // given

        // when
        SortArrayByParity.sortArrayByParity(arr);

        // then
        assertArrayEquals(expectedArr, arr);
    }

    public static List<Arguments> sortArrayByParityProvider() {
        int[] firstCase = {3, 1, 2, 4};
        int[] firstCaseAnswer = {4, 2, 1, 3};
        int[] secondCase = {0, 1, 2};
        int[] secondCaseAnswer = {0, 2, 1};
        return List.of(
                Arguments.of(firstCase, firstCaseAnswer),
                Arguments.of(secondCase, secondCaseAnswer)
        );
    }

}