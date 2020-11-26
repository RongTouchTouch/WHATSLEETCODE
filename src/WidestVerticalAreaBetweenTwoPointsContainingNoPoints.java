import java.util.Arrays;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public int maxWidthOfVerticalArea(int[][] points) {
        int rows = points.length;
        int[] row = new int[rows];
        for(int i = 0; i < rows; i++){
            row[i] = points[i][0];
        }
        Arrays.sort(row);
        int max = 0;
        for(int i = 0; i < rows-1; i++){
            max = Math.max(row[i+1] - row[i], max);
        }
        return max;
    }
}
