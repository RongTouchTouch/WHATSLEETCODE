/***
 * Index: 63
 * Difficulty: Medium
 * Related Topic: Array,, Dynamic Programming
 */

/***
 * 解法一：动态规划
 * 有一个矩阵为[[1]]的情况没考虑到，WA了一次
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length; // 行数
        if(m == 0)
            return 0;
        int n = obstacleGrid[0].length; // 列数

        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(i == m-1 && j ==n-1 && obstacleGrid[i][j] != 1)
                    obstacleGrid[i][j] = 1;
                else if(obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = 0;
                else if (i == m-1 && j <= n-2 &&obstacleGrid[i][j+1]!=0) //问题在这里 这里不一定是1了
                    obstacleGrid[i][j] = 1;
                else if (i == m-1 && j <= n-2 &&obstacleGrid[i][j+1]==0)
                    obstacleGrid[i][j] = 0;
                else if (j == n-1 && i <= m-2 && obstacleGrid[i+1][j]!=0)
                    obstacleGrid[i][j] = 1;
                else if (j == n-1 && i <= m-2 && obstacleGrid[i+1][j]==0)
                    obstacleGrid[i][j] = 0;
                else
                    obstacleGrid[i][j] = obstacleGrid[i+1][j] + obstacleGrid[i][j+1];
            }
        }

        return obstacleGrid[0][0];
    }
}
