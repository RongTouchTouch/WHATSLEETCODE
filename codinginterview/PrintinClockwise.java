public class PrintinClockwise {

    public void print(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int step = 0; step <= (Math.min(rows,cols)-1)/2; step++){
            if(step!=rows-step-1 && step != cols-step-1){
                for(int j = step; j < cols-step-1; j++)
                    System.out.print(matrix[step][j] + " ");
                for(int i = step; i < rows-step-1; i++)
                    System.out.print(matrix[i][cols-step-1] + " ");
                for(int j = cols-step-1; j > step; j--)
                        System.out.print(matrix[rows-step-1][j] + " ");
                for(int i = rows-step-1; i > step; i--)
                    System.out.print(matrix[i][step] + " ");
            }
            if(step==rows-step-1){ //只剩一横排
                for(int j = step; j <= cols-step-1; j++)
                    System.out.print(matrix[step][j] + " ");
            }
            if(step==cols-step-1){ //只剩一纵列
                for(int i = step; i <= rows-step-1; i++)
                    System.out.print(matrix[i][step] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int rows = 10;
        int cols = 5;
        int[][] matrix = new int[rows][cols];
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++){
                matrix[i][j] = i*cols+j+1;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        PrintinClockwise solution = new PrintinClockwise();
        solution.print(matrix);
    }
}
