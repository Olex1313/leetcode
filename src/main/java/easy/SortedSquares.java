package easy;

public class SortedSquares {

    /**
     * @param nums array of sorted in non-decreasing order integers, such as: -10^4 <= nums[i] <= 10^4, 1 <= nums.length <= 10^4
     * @return array of nums squares sorted in non-decreasing order
     * Example: nums = [-4,-1,0,3,10] -> [0,1,9,16,100]
     * Example: nums = [-7,-3,2,3,11] -> [4,9,9,49,121]
     * @see <a href="https://leetcode.com/problems/squares-of-a-sorted-array/?envType=study-plan&id=algorithm-i">Task</a>
     */
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1, i = nums.length - 1;
        var ans = new int[nums.length];
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                ans[i] = nums[left] * nums[left];
                left++;
            } else {
                ans[i] = nums[right] * nums[right];
                right--;
            }
            i--;
        }
        return ans;
    }

}
