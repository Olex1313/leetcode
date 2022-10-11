package easy;

public class SearchInsert {

    /**
     * @param nums array of integers, such as: -10^4 <= nums[i] <= 10^4, 1 <= nums.length <= 10^4
     * @param target integer, such as -10^4 <= target <= 10^4
     * @return index if target is found else index to insert target element
     * Example: nums = [1,3,5,6], target = 2 -> 1
     * Example: nums = [1,3,5,6], target = 7 -> 4
     * Example: nums = [1,3,5,6], target = 5 -> 2
     * @see <a href="https://leetcode.com/problems/number-complement/">Task</a>
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

}
