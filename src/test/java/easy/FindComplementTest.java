package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindComplementTest {

    @ParameterizedTest
    @MethodSource("findComplementProvider")
    public void findComplement(int element, int answer) {
        // given

        // when
        int methodAnswer = FindComplement.findComplement(element);

        // then
        assertEquals(answer, methodAnswer);
    }

    public static List<Arguments> findComplementProvider() {
        return List.of(
                Arguments.of(5, 2),
                Arguments.of(1, 0),
                Arguments.of(12, 3)
        );
    }

}