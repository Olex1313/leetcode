package medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RottingOrangesTest {

    @ParameterizedTest
    @MethodSource("rottingOrangesProvider")
    public void rottingOrangesTest(int answer, int[][] grid) {
        // given
        var solution = new RottingOranges();

        // when
        int actualAnswer = solution.orangesRotting(grid);

        // then
        assertEquals(answer, actualAnswer);
    }

    public static Stream<Arguments> rottingOrangesProvider() {
        int[][] firstCase = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        return Stream.of(
                Arguments.of(4, firstCase)
        );
    }
}
