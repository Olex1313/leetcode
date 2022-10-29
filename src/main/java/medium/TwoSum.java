package medium;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * @param numbers array of integers, sorted in non-decreasing order
     * @param target number to search for
     * @return two numbers such that they add up to a specific target number
     * Example: numbers = [2,7,11,15], target = 9 -> [1,2]
     * The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2.
     * @see <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">Task</a>
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> numsToIndexes = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            numsToIndexes.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            int searchFor = target - numbers[i];
            if (numsToIndexes.containsKey(searchFor)) {
                ans[0] = i + 1;
                ans[1] = numsToIndexes.get(searchFor) + 1;
                return ans;
            }
        }
        return ans;
    }

    public int[] twoSumSearch(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }
            if (sum > target) right--;
            else left++;
        }
        return null;
    }

}
