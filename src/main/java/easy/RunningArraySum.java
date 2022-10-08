package easy;

public class RunningArraySum {

    /**
     * @param nums array of integers in -10^6..10^6
     * @return runningSum array, runningSum[i] = sum(nums[0]…nums[i])
     * Example: [1,2,3,4] -> [1,3,6,10]
     * @see <a href="https://leetcode.com/problems/number-complement/">Task</a>
     */
    public static int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        runningSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            runningSum[i] = runningSum[i - 1] + nums[i];
        }
        return runningSum;
    }

}
