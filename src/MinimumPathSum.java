/***
 * Index: 64
 * Difficulty: Medium
 * Related Topic: Array, Dynamic Programming
 */

/***
 * 解法一：动态规划
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length; // 行数
        if(m == 0)
            return 0;
        int n = grid[0].length; // 列数

        for(int i = 0; i <=m-1 ; i++){
            for(int j = 0; j <= n-1; j++){
                if(i == 0 && j ==0)
                    continue;
                else if (i == 0)
                    grid[i][j] += grid[i][j-1];
                else if (j == 0 )
                    grid[i][j] += grid[i-1][j];
                else
                    grid[i][j] += Math.min(grid[i-1][j] ,grid[i][j-1]);
            }
        }

        return grid[m-1][n-1];
    }

//    比较了一下0ms的实现， 他先做了第0行和第0列的判断，这样在之后的大循环就可以少判断一点。
//    public int minPathSum(int[][] grid) {
//        if (grid.length == 0) {
//            return 0;
//        }
//        int m = grid.length, n = grid[0].length;
//        for ( int i = 1; i < m ; i++) {
//            grid[i][0] += grid[i-1][0];
//        }
//        for ( int i = 1; i < n ; i++) {
//            grid[0][i] += grid[0][i-1];
//        }
//        for ( int i = 1; i < n; i++) {
//            helper (grid,1, i, m, n);
//        }
//        return grid[m-1][n-1];
//    }
//    private void helper(int[][] grid, int i, int j, int m, int n) {
//        if (i >=m || j >= n) {
//            return;
//        }
//        grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
//        helper(grid, i+1, j, m, n);
//    }
}

