package easy;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int i = 0;
        int zeroCount = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                zeroCount++;
            } else {
                nums[i] = nums[j];
                i++;
            }
        }
        int j = nums.length - 1;
        while (zeroCount > 0) {
            nums[j] = 0;
            zeroCount--;
            j--;
        }
    }

    public void moveZeroesWithExchange(int[] nums) {
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                i++;
            }
        }
    }

}
