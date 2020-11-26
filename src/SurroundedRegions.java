/***
 * Index: 130
 * Difficulty: Medium
 * Related Topic: Depth-First Search, Breadth-First Search, Union Find
 */

public class SurroundedRegions {
    int[] direction = {0, -1, 0, 1, 0};

    public void solve(char[][] board) {
        if(board.length==0)
            return;
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                dfs(i, 0, board, visited);
            }
            if (board[i][cols-1] == 'O' && !visited[i][cols-1]) {
                dfs(i, cols-1, board, visited);
            }
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O' && !visited[0][j]) {
                dfs(0, j, board, visited);
            }
            if (board[rows-1][j] == 'O' && !visited[rows-1][j]) {
                dfs(rows-1, j, board, visited);
            }
        }
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if(!visited[i][j] && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    public void dfs(int row, int col, char[][]board, boolean[][] visited){
        int rows = board.length;
        int cols = board[0].length;
        if(row < 0 || row > rows-1 || col < 0 || col > cols-1|| board[row][col] == 'X' || visited[row][col])
            return;
        if(board[row][col] == 'O'){
            visited[row][col] = true;
            for(int k = 0; k < 4; k++)
                dfs(row+direction[k], col+direction[k+1], board, visited);
        }
    }

    public static void main(String[] args){
        char[][] board = {{'O','X','X','O','X','X'},{'X','O','O','X','O','X'},{'X','O','X','O','O','X'},{'O','X','O','X','O','X'},{'X','X','O','X','O','X'}};
        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
        System.out.println();
        SurroundedRegions solution = new SurroundedRegions();
        solution.solve(board);
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
                }
            System.out.println();
            }
    }
}
