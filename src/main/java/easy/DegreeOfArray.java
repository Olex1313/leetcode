package easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray {

    /**
     * @param nums array of integers in 0 49_999
     * @return amount of max frequent element
     * Example: [1,2,2,3,1] -> 2
     * @see <a href="https://leetcode.com/problems/degree-of-an-array/">Task</a>
     */
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> rightPos = new HashMap<>();
        Map<Integer, Integer> leftPos = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            leftPos.putIfAbsent(nums[i], i);
            rightPos.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        int degree = Collections.max(count.values());
        int min = nums.length;
        for (var e : count.entrySet()) {
            if (e.getValue() == degree) {
                min = Math.min(min, rightPos.get(e.getKey()) - leftPos.get(e.getKey()) + 1);
            }
        }
        return min;
    }

}
