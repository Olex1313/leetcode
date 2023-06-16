package parallel;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArraySummarizerTest {

    @ParameterizedTest
    @MethodSource("summarizeProvider")
    void summarize(int threadsCount, int[] array) {
        // given
        var arraySummarizer = new ArraySummarizer(threadsCount);

        // when

        long start = System.currentTimeMillis();
        int sum = arraySummarizer.summarize(array);
        long end = System.currentTimeMillis();

        // then
        int actualSum = Arrays.stream(array).sum();
        assertEquals(actualSum, sum);
        System.out.printf("Compleated in %d milliseconds\n", end - start);
    }

    public static Stream<Arguments> summarizeProvider() {
        List<Integer> threadsCount = List.of(1, 2, 4, 6, 8, 10, 15, 20);
        List<Integer> arrAmounts = List.of(100, 1000, 10000);
        List<Arguments> args = new ArrayList<>(threadsCount.size() * arrAmounts.size());
        for (var tc : threadsCount) {
            for (var arr : arrAmounts) {
                args.add(Arguments.of(tc, randomList(arr)));
            }
        }
        return args.stream();
    }

    private static int[] randomList(int length) {
        int[] arr = new int[length];
        var random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(0, 1000);
        }
        return arr;
    }
}