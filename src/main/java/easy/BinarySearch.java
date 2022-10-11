package easy;

public class BinarySearch {

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target < nums[mid]) high = mid - 1;
            if (target > nums[mid]) low = mid + 1;
            if (target == nums[mid]) return mid;
        }
        return -1;
    }

}
