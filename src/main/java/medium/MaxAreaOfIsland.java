package medium;

public class MaxAreaOfIsland {
    int[][] grid;
    boolean[][] seen;

    public int maxAreaOfIsland(int[][] givenGrid) {
        this.grid = givenGrid;
        this.seen = new boolean[givenGrid.length][givenGrid[0].length];
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, islandSize(i, j));
            }
        }
        return max;
    }

    private int islandSize(int i, int j) {
        if (seen[i][j] || grid[i][j] == 0) return 0;
        int up = (i >= 1) ? islandSize(i - 1, j) : 0;
        int down = (i < grid.length - 1) ? islandSize(i + 1, j) : 0;
        int right = (j < grid[0].length - 1) ? islandSize(i, j + 1) : 0;
        int left = (j >= 1) ? islandSize(i, j - 1) : 0;
        seen[i][j] = true;
        return up + down + right + left + 1;
    }

}
