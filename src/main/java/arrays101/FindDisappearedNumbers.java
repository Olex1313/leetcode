package arrays101;

import java.util.List;

public class FindDisappearedNumbers {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int[] range = new int[nums.length];
        for(int i = 1; i <= nums.length; i++) {
            range[i - 1] = i;
        }
        
        return null;
    }

}
