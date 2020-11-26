import java.util.Arrays;

/***
 * Index: 200
 * Difficulty: Medium
 * Related Topic: Union Find
 */

/***
 * 解法一：Union Find(正确)
 * 我感觉我终于有点参悟Union Find是怎么回事了，太折磨人了。
 * WA了一次，注意“cols * i + j”是cols不是rows!
 * 虽然正确但是速度慢的很，5ms还是后百分之10。
 */

class UnionFind {
    public final int[] parent;
    public int islands;

    public UnionFind(int n) {
        parent = new int[n];
        Arrays.fill(parent, -1);
        islands = 0;
    }

    public int find(int p) {
        if (parent[p] == -1) {
            parent[p] = p;
            this.islands++;
        }
        while (p != parent[p])
            p = parent[p];
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i != j) {
            parent[i] = j;
            islands--;
        }
    }
}

public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        UnionFind unionFind = new UnionFind(rows * cols);
        int[] direction = new int[]{0, -1, 0, 1, 0};
        for( int i = 0; i < rows; i++ ){
            for( int j = 0; j < cols; j++){
                if(grid[i][j] == '1'){
                    for(int k = 0; k < 4; k++)
                    {
                        unionFind.find(cols*i+j);

                        if (i+direction[k] >=0 && i+direction[k] <rows && j+direction[k+1]>=0 && j+direction[k+1] < cols && grid[i+direction[k]][j+direction[k+1]] == '1')
                            unionFind.union(cols * i + j, cols * (i + direction[k]) + j + direction[k + 1]);
                    }
                }
            }
        }
        return unionFind.islands;
    }

    public static void main(String[] args){
        char[][] grid = {{'1','1','0','0'}, {'1','1','0','0'}, {'0','1','0','0'}, {'0','0','1','1'}, {'0','0','1','1'}};
        NumberofIslands solution = new NumberofIslands();
        int result = solution.numIslands(grid);
        System.out.println(result);
    }
}

/***
 * 解法二：DFS
 * 快了一点，2ms，后50%
 */

//public class NumberofIslands {
//    int[] direction = {0,-1,0,1,0};
//    public int numIslands(char[][] grid) {
//        int rows = grid.length;
//        int cols = grid[0].length;
//        boolean[] visited = new boolean[rows*cols];
//        int islands = 0;
//        for(int i = 0; i < rows; i++){
//            for(int j = 0; j < cols; j++){
//                if (!visited[cols * i + j] && grid[i][j] == '1'){
//                    dfs(i,j,grid,visited);
//                    islands++;
//                }
//            }
//        }
//        return islands;
//    }
//
//    public void dfs(int row, int col, char[][]grid, boolean[] visited){
//        int rows = grid.length;
//        int cols = grid[0].length;
//        if(!visited[grid[0].length * row + col]){
//            visited[grid[0].length * row + col] = true;
//            for(int k = 0; k < 4; k++)
//                    {
//                        if (row+direction[k] >=0 && row+direction[k] <rows && col+direction[k+1]>=0 && col+direction[k+1] < cols && grid[row+direction[k]][col+direction[k+1]] == '1')
//                            dfs(row+direction[k], col+direction[k+1],grid,visited);
//                    }
//        }
//    }
//
//    // 其实甚至visited都能省掉
//    // 重写了一下DFS，变成1ms了，进入99%
//    public void dfs(int row, int col, char[][]grid, boolean[] visited){
//        int rows = grid.length;
//        int cols = grid[0].length;
//        if(row < 0 || row >= rows || col < 0 || col >= cols || visited[cols*row + col])
//            return;
//        visited[cols*row + col] = true;
//        if(grid[row][col] == '0')
//            return;
//        for(int k = 0; k < 4; k++)
//        {
//            dfs(row+direction[k], col+direction[k+1], grid, visited);
//        }
//    }
//
//    public static void main(String[] args){
//        char[][] grid = {{'1','1','0','0'}, {'1','1','0','0'}, {'0','1','0','0'}, {'0','0','1','1'}, {'0','0','1','1'}};
//        NumberofIslands solution = new NumberofIslands();
//        int result = solution.numIslands(grid);
//        System.out.println(result);
//    }
//}
