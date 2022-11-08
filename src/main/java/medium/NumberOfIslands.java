package medium;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int sum = 0;
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!seen[i][j]) {
                    sum += findIslandNearby(grid, seen, i, j);
                }
            }
        }
        return sum;
    }

    private int findIslandNearby(char[][] grid, boolean[][] seen, int i, int j) {
        if (seen[i][j] || grid[i][j] == '0') return 0;
        seen[i][j] = true;
        if (i >= 1) findIslandNearby(grid, seen, i - 1, j);
        if (i < grid.length - 1) findIslandNearby(grid, seen, i + 1, j);
        if (j >= 1) findIslandNearby(grid, seen, i, j - 1);
        if (j < grid[0].length - 1) findIslandNearby(grid, seen, i, j + 1);
        return 1;
    }

}
