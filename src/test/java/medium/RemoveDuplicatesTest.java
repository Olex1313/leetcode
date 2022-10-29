package medium;

import medium.RemoveDuplicates.Node;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicatesTest {

    private final RemoveDuplicates removeDuplicates = new RemoveDuplicates();

    @ParameterizedTest
    @MethodSource("removeDuplicatesProvider")
    void removeDuplicates(Node head, Node answer) {
        // given

        // when
        removeDuplicates.removeDuplicates(head);

        // then
        for (Node top1 = head, top2 = answer; top1 != null || top2 != null; top1= top1.next, top2 = top2.next) {
            assertEquals(top1.val, top2.val);
        }
    }

    @ParameterizedTest
    @MethodSource("removeDuplicatesProvider")
    void removeDuplicatesWithNoBuffer(Node head, Node answer) {
        // given

        // when
        removeDuplicates.removeDuplicatesWithNoBuffer(head);

        // then
        for (Node top1 = head, top2 = answer; top1 != null || top2 != null; top1= top1.next, top2 = top2.next) {
            assertEquals(top1.val, top2.val);
        }
    }

    public static Stream<Arguments> removeDuplicatesProvider() {
        var firstHead = Node.builder()
                .withNode(1)
                .withNode(3)
                .withNode(7)
                .withNode(3)
                .withNode(1)
                .build();
        var firstAnswer = Node.builder()
                .withNode(1)
                .withNode(3)
                .withNode(7)
                .build();
        var secondHead = Node.builder()
                .withNode(1)
                .build();
        var secondAnswer = Node.builder()
                .withNode(1)
                .build();
        var thirdHead = Node.builder()
                .withNode(1)
                .withNode(2)
                .withNode(2)
                .withNode(1)
                .build();
        var thirdAnswer = Node.builder()
                .withNode(1)
                .withNode(2)
                .build();
        return Stream.of(
                Arguments.of(firstHead, firstAnswer),
                Arguments.of(secondHead, secondAnswer),
                Arguments.of(thirdHead, thirdAnswer)
        );
    }

}