package arrays101;

public class SortArrayByParity {

    /**
     * @param nums array of integers in 1..5000 with length in 0..5000
     * @return nums with all even numbers to the left and odd to the right
     * Example: [3, 1, 2, 4] -> [4, 2, 1, 3]
     * @see <a href="https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3258/">Task</a>
     */
    public static int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 > nums[right] % 2) {
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
            }
            if (nums[left] % 2 == 0) {
                left++;
            }
            if (nums[right] % 2 != 0) {
                right--;
            }
        }
        return nums;
    }

}
