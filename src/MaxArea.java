/***
 * 解法一（自己写的）
 * 1. 最蠢的，把每个area的面积算出来
 * （而且只需要算上三角矩阵就可以了，也没想到）
 */
//public class MaxArea {
//    public int maxArea(int[] height) {
//        int size = height.length;
//        int[][] area = new  int[size][size];
//        int max_area = -1;
//        for (int i = 0; i < size; i++)
//            for (int j = 0; j < size; j++) {
//                area[i][j] = (j - i) * Integer.min(height[i], height[j]);
//                if (area[i][j] > max_area){
//                    max_area = area[i][j];
//                }
//            }
//        return max_area;
//    }
//    public static void main(String agrv[]){
//        int[] height = {1,8,6,2,5,4,8,3,7};
//        MaxArea  solution = new MaxArea ();
//        int result = solution.maxArea(height);
//        System.out.println(result);
//    }
//}

/***
 * 解法二（这个解非常妙，只需要O(n)的时间复杂度和O(1)的空间复杂度即可）
 * https://leetcode.com/problems/container-with-most-water/discuss/6099/Yet-another-way-to-see-what-happens-in-the-O(n)-algorithm
 * 1. 先去除对角线以及下三角
 * 2. 首先考虑第1根木板和第n根木板，如果说第1根的木板比第n根的木板，那么此时去考虑第1根木板与第i(i<n)根木板之间是否可能
 *    有最大area是没有意义的，因为高度最大也只是第1根木板的高度，而宽在不断的缩减
 * 3. 以此类推，直到木板的间距不能再缩短
 * （可以从矩阵的角度看这个问题）
 *
 * 4. 我交的时候犯了一个错误，就是这里已经不需要再创建size*size的matrix了，结果导致Memory Limit Exceeded
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int size = height.length;
        int area;
        int max_area = -1;
        for (int i = 0, j = size-1; i < size-1 && j > 0; ){
            area = (j - i) * Integer.min(height[i], height[j]);
            if (area > max_area){
                max_area = area;
            }
            if(height[i] < height[j])
                i++;
            else if(height[i] >= height[j])
                j--;
        }
        return max_area;
    }
    public static void main(String agrv[]){
        int[] height = {1,8,6,2,5,4,8,3,7};
        MaxArea  solution = new MaxArea ();
        int result = solution.maxArea(height);
        System.out.println(result);
    }
}