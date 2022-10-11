package medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringWithoutRepeatingCharsTest {

    @ParameterizedTest
    @MethodSource("lengthOfLongestSubstringProvider")
    void lengthOfLongestSubstring(String s, int answer) {
        // given
        var solution = new LongestSubstringWithoutRepeatingChars();

        // when
        var length = solution.lengthOfLongestSubstring(s);

        // then
        assertEquals(answer, length);
    }

    public static Stream<Arguments> lengthOfLongestSubstringProvider() {
        return Stream.of(
                Arguments.of("pwwkew", 3),
                Arguments.of("bbbbb", 1),
                Arguments.of("abcabcbb", 3),
                Arguments.of("dvdf", 3)
        );
    }

}