package arrays101;

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

}