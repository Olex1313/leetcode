package rotateImage;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @ParameterizedTest(name = "given {0}, should rotate to {1}")
    @MethodSource("rotateProvider")
    void rotate(int[][] givenMatrix, int[][] expectedMatrix) {
        // given

        // when
        Solution.rotate(givenMatrix);

        // then
        assertTrue(Arrays.deepEquals(givenMatrix, expectedMatrix));
    }

    public static List<Arguments> rotateProvider() {
        int[][] firstMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] firstMatrixRotated = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };
        int[][] secondMatrix = {{1}};
        int[][] secondMatrixRotated = {{1}};
        int[][] thirdMatrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        int[][] thirdMatrixRotated = {
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11}
        };
        return List.of(
                Arguments.of(firstMatrix, firstMatrixRotated),
                Arguments.of(secondMatrix, secondMatrixRotated),
                Arguments.of(thirdMatrix, thirdMatrixRotated)
        );
    }
}