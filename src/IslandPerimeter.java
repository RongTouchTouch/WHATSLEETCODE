import javafx.util.Pair;

/***
 * Index: 463
 * Difficulty: Easy
 * Related Topic:
 */

/**
 * 解法一：DFS（正确）
 * 我真是思维僵化了。。遇到这种题就用DFS，这样真不好
 * 长知识了，，不能在LC里面用static
 */
public class IslandPerimeter {
    int[] direction = {0, -1, 0, 1, 0};
    int count = 0, dup = 0;

    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        boolean[][] visited2 = new boolean[rows][cols];

        for(int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!visited[row][col] && grid[row][col] == 1){
                    dfs(grid, row, col, visited);
                    dfs2(grid, row, col,visited2);
                }
            }
        }
        System.out.println(count);
        System.out.println(dup);
        return count - dup;
    }

    public void dfs(int[][]grid, int row, int col, boolean[][] visited){
        int rows = grid.length;
        int cols = grid[0].length;
        if(row < 0 || row >= rows || col < 0 || col >= cols|| visited[row][col])
            return;
        visited[row][col] = true;
        if (grid[row][col] == 1)
        {
            count += 4;
            for (int i = 0; i < 4; i++){
                dfs(grid, row+direction[i], col+direction[i+1], visited);
            }
        }
    }

    public void dfs2(int[][]grid, int row, int col, boolean[][]visited){
        int rows = grid.length;
        int cols = grid[0].length;
        visited[row][col] = true;
        if(grid[row][col] == 0)
            return;
        for (int i = 0; i < 4; i++){
            int new_row = row+direction[i];
            int new_col = col+direction[i+1];
            if(!(new_row < 0 || new_row >= rows || new_col < 0 || new_col >= cols || grid[new_row][new_col] == '0')) {
                dup++;
                if(!visited[new_row][new_col])
                    dfs2(grid, new_row, new_col, visited);
            }
        }
    }

    public static void main(String[] args){
        int[][] grid = {{0,1,0,0},{1,1,1,0},{1,1,0,0},{1,1,0,0}};
        IslandPerimeter islandPerimeter = new IslandPerimeter();
        int result = islandPerimeter.islandPerimeter(grid);
        System.out.println(result);
    }
}

/***
 * 解法二：
 * 题解里面说只可能有一个孤立岛，虽然TestCase中出现多个只会计算一个，但还是应该尊重提意，没必要去想那么多
 * 发现别人写的真是妙啊。。其实很好想到能按顺序做，只是没想到能这么做。。
 */
class IslandPerimeter2 {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int result = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    result += 4;

                    if (r > 0 && grid[r - 1][c] == 1) {
                        result -= 2;
                    }

                    if (c > 0 && grid[r][c - 1] == 1) {
                        result -= 2;
                    }
                }
            }
        }

        return result;
    }
}