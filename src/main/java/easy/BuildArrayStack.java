package easy;

import java.util.ArrayList;
import java.util.List;

public class BuildArrayStack {

    private enum Operation {
        PUSH("Push"),
        POP("Pop");

        private String value;

        Operation(String value) {
            this.value = value;
        }

    }

    /**
     * @param target array of integers target[i] in 1..n, target is increasing
     * @param n      right border of given array
     * @return list of operations to build an Array
     * Example: target = [1,2,3], n = 3 -> Answer : ["Push","Push","Push"]
     * Example: target = [1,2], n = 4 -> Answer : ["Push","Push"]
     * @see <a href="https://leetcode.com/problems/number-complement/">Task</a>
     */
    public List<String> buildArray(int[] target, int n) {
        var operations = new ArrayList<String>();
        int j = 0;
        for(int i = 1; i <= n && j < target.length; i++) {
            operations.add(Operation.PUSH.value);
            if (target[j] == i) {
                j++;
            } else {
                operations.add(Operation.POP.value);
            }
        }
        return operations;
    }

}
