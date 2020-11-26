public class DFS {
    int[] direction = {0, -1, 0, 1, 0};
    public void main(int[][]grid){
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for(int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!visited[row][col])
                    dfs(grid, row, col, visited);
            }
        }
    }

    public void dfs(int[][]grid, int row, int col, boolean[][] visited){
        int rows = grid.length;
        int cols = grid[0].length;
        if(row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col])
            return;
        visited[row][col] = true;
        for (int i = 0; i < 4; i++){
            dfs(grid, row+direction[i], col+direction[i+1], visited);
        }
    }
}
