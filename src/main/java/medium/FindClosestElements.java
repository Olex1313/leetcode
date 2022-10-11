package medium;

import java.util.ArrayList;
import java.util.List;

public class FindClosestElements {

    /**
     * @param arr sorted in ascending order array of integers
     * @param k   amount of the closest elements to find
     * @param x   target integer, to search the closest elements
     * @return list of the closest to x integers, such as
     * an integer A is closer to X than integer B if:
     * |A - X| < |B - X| || (A < B && |A - X| == |B - X|)
     * Example: arr = [1,2,3,4,5], k = 4, x = 3 -> [1,2,3,4]
     * Example: arr = [1,2,3,4,5], k = 4, x = -1 -> [1,2,3,4]
     * @see <a href="https://leetcode.com/problems/find-k-closest-elements/">Task</a>
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1;
        for (int i = arr.length - k; i > 0; i--) {
            if (Math.abs(arr[right] - x) > Math.abs(arr[left] - x)) {
                right--;
            } else {
                left++;
            }
        }
        var ans = new ArrayList(k);
        for (int i = 0; i < k; i++) {
            ans.add(arr[left++]);
        }
        return ans;
    }

}
