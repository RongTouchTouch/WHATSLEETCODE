/***
 * Index: 53
 * Difficulty: Easy
 * Related Topic: Array, Divide and Conquer, Dynamic Programming
 */

public class MaximumSubarray {
//        //1ms
//        public int maxSubArray(int[] nums) {
//        int max = Integer.MIN_VALUE, temp = 0;
//        int start = 0;
//        while (start < nums.length){
//            int cur = nums[start];
//            if(cur > 0)
//                temp += cur;
//            else if(cur + temp > 0) {
//                temp += cur;
//            }
//            else // cur + temp<0 cur<0 temp>=0
//                temp = 0;
//            start++;
//            if(temp > max)
//                max = temp;
//        }
//        if(max == 0){
//            int new_max = Integer.MIN_VALUE;
//            for(int i = 0; i < nums.length; i++){
//                if(nums[i] > new_max)
//                    new_max = nums[i];
//            }
//            return new_max;
//        }
//        else
//            return max;
//    }
    //0ms 对算法进行优化
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, temp = 0;
        int start = 0;
        while (start < nums.length){
            int cur = nums[start];
            if(cur + temp > 0){
                temp += cur;
                if(temp > max)
                    max = temp;
            }
            else {
                temp = 0;
                max = Math.max(max, cur);
            }
            start++;
        }
        return max;
    }

    public static void main(String args[]){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray solution = new MaximumSubarray();
        int result = solution.maxSubArray(nums);
        System.out.println(result);
    }
}
