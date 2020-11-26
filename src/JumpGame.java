/***
 * Index: 55
 * Difficulty: Medium
 * Related Topic: Array, Greedy
 */

/***
 * 解法一：（正确）
 * 没想到这个居然会那么慢。。1140 ms, faster than 5.03%，而且用的O(n)的空间也很大
 */
//public class JumpGame {
//    public boolean canJump(int[] nums) {
//        boolean[] temp = new boolean[nums.length];
//        temp[0] = true;
//        for (int i = 0; i < nums.length; i++) {
//            if (temp[i])
//                for (int j = 1; j <= nums[i] && i+j < nums.length; j++)
//                    temp[i + j] = true;
//        }
//        return temp[nums.length - 1];
//    }
//
//    public static void main(String[] args){
//       int[] nums = {1,4,12,5,5,7,1,8,1,9,7,0,8,5};
//       JumpGame solution = new JumpGame();
//       boolean result = solution.canJump(nums);
//       System.out.println(result);
//    }
//}
/***
 * 解法二：（正确）
 * 超了一个0ms的答案，我其实原来也想过从后往前算，但当时确实没想出来
 * 其实多想一下，这个确实是可行的。太牛了。
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public static void main(String[] args){
        int[] nums = {1,4,12,5,5,7,1,8,1,9,7,0,8,5};
        JumpGame solution = new JumpGame();
        boolean result = solution.canJump(nums);
        System.out.println(result);
    }
}