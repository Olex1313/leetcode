package rotateImage;

public class Solution {

    /**
     * @see <a href="https://leetcode.com/problems/rotate-image/">Task</a>
     * @param matrix square matrix n x n, where n >= 1
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int left = 0;
        int right = n - 1;
        while(left < right) {
            for(int i = 0; i < right - left; i++) {
                int top = left;
                int bottom = right;
                int topLeft = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = topLeft;
            }
            right -= 1;
            left += 1;
        }
    }

}
