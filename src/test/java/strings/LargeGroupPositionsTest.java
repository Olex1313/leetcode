package strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LargeGroupPositionsTest {

    @ParameterizedTest
    @MethodSource("largeGroupPositionsProvider")
    public void largeGroupPositions(String s, List<List<Integer>> expectedSubstr) {
        // given

        // when
        List<List<Integer>> answer = LargeGroupPositions.largeGroupPositions(s);

        // then
        assertEquals(expectedSubstr, answer);
    }

    public static List<Arguments> largeGroupPositionsProvider() {
        return List.of(
                Arguments.of("xxxabc", List.of(List.of(0, 2))),
                Arguments.of("abc", List.of()),
                Arguments.of("abcxxx", List.of(List.of(3, 5)))
        );
    }

}