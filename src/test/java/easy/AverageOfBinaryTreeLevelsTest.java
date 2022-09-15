package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AverageOfBinaryTreeLevelsTest {

    @ParameterizedTest
    @MethodSource("averageOfLevelsProvider")
    void averageOfLevels(AverageOfBinaryTreeLevels.TreeNode root, List<Double> expectedAnswer) {
        // given

        // when
        var ans = AverageOfBinaryTreeLevels.averageOfLevels(root);

        // then
        assertArrayEquals(expectedAnswer.stream().mapToDouble(t -> t).toArray(), ans.stream().mapToDouble(t -> t).toArray(), 0.1d);
    }

    public static Stream<Arguments> averageOfLevelsProvider() {
        var root = new AverageOfBinaryTreeLevels.TreeNode(3);
        root.left = new AverageOfBinaryTreeLevels.TreeNode(9);
        var right = new AverageOfBinaryTreeLevels.TreeNode(20);
        root.right = right;
        right.left = new AverageOfBinaryTreeLevels.TreeNode(15);
        right.right = new AverageOfBinaryTreeLevels.TreeNode(7);
        return Stream.of(Arguments.of(root, List.of(3.0, 14.5, 11.0)));
    }


}