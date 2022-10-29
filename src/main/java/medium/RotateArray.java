package medium;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) copy[i] = nums[i];
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = copy[i];
        }
    }

}
