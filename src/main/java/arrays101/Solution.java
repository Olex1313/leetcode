package arrays101;

import utils.NumberUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    /**
     * @param nums array of integers with value 0 or 1
     * @return maximum number of consecutive 1's in array
     * @see <a href="https://leetcode.com/explore/featured/card/fun-with-arrays/521/introduction/3238/">Task</a>
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int buffer = 0;
        int max = 0;
        for (int num : nums) {
            switch (num) {
                case 0 -> {
                    max = Math.max(buffer, max);
                    buffer = 0;
                }
                case 1 -> buffer++;
            }
        }
        return Math.max(buffer, max);
    }

    /**
     * @param nums array of integers in between 1..10^5
     * @return amount of numbers with an even number of digits
     * @see <a href="https://leetcode.com/explore/featured/card/fun-with-arrays/521/introduction/3237/">Task</a>
     */
    public static int findNumbers(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int num : nums) {
            if (NumberUtils.isEven(NumberUtils.numberOfDigits(num))) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param array array of integers in 0..9
     *              Duplicates zeroes in array
     * @see <a href="https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3245/">Task</a>
     */
    public static void duplicateZeroes(int[] array) {
        boolean lastChanged = false;
        for (int i = 0; i < array.length - 1; ) {
            if (array[i] == 0) {
                for (int j = array.length - 1; j > i + 1; j--) {
                    array[j] = array[j - 1];
                }
                array[i + 1] = 0;
                lastChanged = true;
            }
            i += (lastChanged) ? 2 : 1;
            lastChanged = false;
        }
    }

    /**
     * @param nums array of integers in 0..50 with nums.length in 0..100
     * @param val  value to remove
     * @return number of elements left in array
     * Removes val from array
     * @see <a href="https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3247/">Task</a>
     */
    public static int removeElement(int[] nums, int val) {
        int j = 0; // pointer to element in "new" array
        for (int i = 0; i < nums.length && j < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    /**
     * @param arr array of integers in 10^-3..10^3 with length in 2..500
     * @return Checks if there exists two indices i and j such that i != j
     * and arr[i] == 2 * arr[j]
     * @see <a href="https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3250/">Task</a>
     */
    public static boolean checkIf(int[] arr) {
        Set<Integer> numToIndex = new HashSet<>();
        for (int num : arr) {
            if (numToIndex.contains(num * 2)) {
                return true;
            }
            if (numToIndex.contains(num / 2) && num % 2 == 0) {
                return true;
            }
            numToIndex.add(num);
        }
        return false;
    }

}