package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniqueStringTest {

    @ParameterizedTest
    @MethodSource("allUniqueProvider")
    public void allUnique(String s, boolean expectedAnswer) {
        // given
        var solution = new UniqueString();

        // when
        var answer = solution.allUnique(s);

        // then
        assertEquals(expectedAnswer, answer);
    }

    public static Stream<Arguments> allUniqueProvider() {
        return Stream.of(
                Arguments.of("abc", true),
                Arguments.of("aabc", false)
        );
    }

}
