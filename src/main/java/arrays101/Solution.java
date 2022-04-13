package arrays101;

import utils.NumberUtils;

class Solution {

    /**
     * @see <a href="https://leetcode.com/explore/featured/card/fun-with-arrays/521/introduction/3238/">Task</a>
     * @param nums array of integers with value 0 or 1
     * @return maximum number of consecutive 1's in array
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
     * @see <a href="https://leetcode.com/explore/featured/card/fun-with-arrays/521/introduction/3237/">Task</a>
     * @param nums array of integers in between 1..10^5
     * @return amount of numbers with an even number of digits
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


}