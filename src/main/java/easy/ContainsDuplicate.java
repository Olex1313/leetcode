package easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /**
     * @param nums array of integers in -10^9..10^9
     * @return true if array contains duplicate element
     * Example: [1,2,3,1] -> true
     * @see <a href="https://leetcode.com/problems/contains-duplicate">Task</a>
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> seenElements = new HashSet<>();
        for (int num : nums) {
            if (seenElements.contains(num)) {
                return true;
            }
            seenElements.add(num);
        }
        return false;
    }

}
