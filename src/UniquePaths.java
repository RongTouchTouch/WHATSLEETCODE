/***
 * Index: 62
 * Difficulty: Medium
 * Related Topic: Array,, Dynamic Programming
 */

/***
 * 解法一：递归
 * 交完就后悔了，果然超时了
 */
public class UniquePaths {
//    public int uniquePaths(int m, int n) {
//        if(m == 1 || n == 1)
//            return 1;
//        else
//            return uniquePaths(m-1, n) + uniquePaths(m, n-1);
//    }

    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0)
                    matrix[i][j] = 1;
                else matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
            }
        }
        return matrix[m-1][n-1];
    }

    public static void main(String args[]){
        int m = 7;
        int n = 3;
        UniquePaths solution = new UniquePaths();
        int result = solution.uniquePaths(m, n);
        System.out.println(result);
    }
}
