/***
 * Index: 42
 * Difficulty: Hard
 * Related Topic: Array, Two Pointers, Stack
 */

/***
 * 解法一：暴力破解
 */
//public class TrappingRainWater {
//    public int trap(int[] height) {
//        int sum = 0;
//        for (int i = 0; i < height.length; i++){
//            int left = height[i], right=height[i];
//            for(int j = i; j >= 0; j--)
//                if(left < height[j])
//                    left = height[j];
//            for(int j = i; j < height.length; j++)
//                if(right < height[j])
//                    right = height[j];
//            sum += (Math.min(left, right) - height[i] > 0 ? Math.min(left, right) - height[i] : 0);
//            }
//        return sum;
//    }
//    public static void main(String args[]){
//        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//        TrappingRainWater solution = new TrappingRainWater();
//        int result = solution.trap(height);
//        System.out.println(result);
//    }
//}

/***
 * 解法二：动态规划
 * 动态规划的速度竟然要比暴力破解来得慢，没想到。
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if(height.length < 1)
            return 0;
        int sum = 0;
        int[] left_max = new int[height.length];
        left_max[0] = height[0];
        for (int i = 1; i < height.length; i++){
            left_max[i] = Math.max(left_max[i-1], height[i-1]);
        }
        int[] right_max = new int[height.length];
        right_max[height.length-1] = height[height.length-1];
        for(int i = height.length-2; i >= 0; i--){
            right_max[i] = Math.max(right_max[i+1], height[i+1]);
        }
        for (int i = 0; i < height.length; i++){
            sum += (Math.min(left_max[i], right_max[i]) - height[i] > 0 ? Math.min(left_max[i], right_max[i]) - height[i] : 0);
        }
        return sum;
    }
    public static void main(String args[]){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater solution = new TrappingRainWater();
        int result = solution.trap(height);
        System.out.println(result);
    }
}