package utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberUtilsTest {

    @ParameterizedTest
    @MethodSource("isEvenProvider")
    void isEven(int number, boolean expectedAnswer) {
        // given

        // when
        boolean actualAnswer = NumberUtils.isEven(number);

        // then
        assertEquals(expectedAnswer, actualAnswer);
    }

    @ParameterizedTest
    @MethodSource("numberOfDigitsProvider")
    void numberOfDigits(int number, int expectedNumberOfDigits) {
        // given

        // when
        int actualNumberOfDigits = NumberUtils.numberOfDigits(number);

        // then
        assertEquals(expectedNumberOfDigits, actualNumberOfDigits);
    }

    public static List<Arguments> isEvenProvider() {
        return List.of(
                Arguments.of(4, true),
                Arguments.of(1, false),
                Arguments.of(6, true),
                Arguments.of(3, false)
        );
    }

    public static List<Arguments> numberOfDigitsProvider() {
        return List.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(111, 3),
                Arguments.of(541, 3),
                Arguments.of(10000, 5)
        );
    }
}