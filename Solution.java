import java.util.*

class Solution {
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        boolean[][] visited = new boolean[grid.length][];
        for (int i1 = 0; i1 < visited.length; i1++) {
            visited[i1] = new boolean[grid[i1].length];
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    numOfIslands++;
                    findAdjacentLand(grid, i, j, visited);
                }
            }
        }
        return numOfIslands;
    }

    private void findAdjacentLand(char[][] grid, int i, int j, boolean[][] visited) {
        if (i >= 0 && j >= 0
                && i < grid.length && j < grid[i].length
                && grid[i][j] == '1'
                && !visited[i][j]
            ) {
            visited[i][j] = true;
            // try to find adjacent land in all 4 directions around this cell
            // Diagonal searching is not needed

            // search on left side
            findAdjacentLand(grid, i - 1, j, visited);

            // search right side
            findAdjacentLand(grid, i + 1, j, visited);

            // search above
            findAdjacentLand(grid, i, j - 1, visited);

            // search below
            findAdjacentLand(grid, i, j + 1, visited);
        }
    }
}