package medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> rotting = new LinkedList<>();
        int oranges = 0, minutes = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) oranges++;
                if (grid[i][j] == 2) {
                    int[] point = new int[]{i, j};
                    rotting.offer(point);
                }
            }
        }

        if (oranges == 0) return 0;

        int[][] routes = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while (!rotting.isEmpty() && oranges > 0) {
            minutes++;
            for (int i = rotting.size(); i > 0; i--) {
                int[] point = rotting.poll();
                for (int[] route : routes) {
                    int r = point[0] + route[0], c = point[1] + route[1];
                    if (
                        r >= 0 &&
                        r < grid.length &&
                        c >= 0 &&
                        c < grid[0].length &&
                        grid[r][c] == 1
                    ) {
                        grid[r][c] = 2;
                        oranges--;
                        rotting.offer(new int[]{r, c});
                    }
                }
            }
        }
        return (oranges == 0) ? minutes : -1;
    }

}
