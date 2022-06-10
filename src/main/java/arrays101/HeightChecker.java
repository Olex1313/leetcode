package arrays101;

import java.util.Arrays;

public class HeightChecker {

    public static int heightChecker(int[] heights) {
        int diff = 0;
        int[] copy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);
        for (int i = 0; i < heights.length; i++) {
            if(copy[i] != heights[i]) {
                diff++;
            }
        }
        return diff;
    }

}
