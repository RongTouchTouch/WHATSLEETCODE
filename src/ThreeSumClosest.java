import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/***
 * 解法一
 * 和3Sum差不多
 * 我犯了两个错误，一个是在设interval的时候越界了，index设了1，2，3，属于白给
 * 还有一个WA case: nums = [-1,0,1,1,55] target = 3 我错在擅自使用
 *  for (; j < k && nums[j] == nums[j + 1]; j++) ;把第二个1给吞掉了
 *  解决方法就i是直接把两行都注销掉
 *
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int interval = nums[0] + nums[1] + nums[2] - target; // interval is nums-target
        for(int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int temp = nums[i] + nums[j] + nums[k];
                if (temp < target)
                    j++;
                else if (temp >= target)
                    k--;
                if (Math.abs(target - temp) < Math.abs(interval)) {
                    interval = temp - target;
//                    for (; j < k && nums[j] == nums[j + 1]; j++) ;
//                    for (; j < k && nums[k] == nums[k - 1]; k--) ;
                }
            }
        }
        return interval + target;
    }
    public static void main(String agrv[]){
        int[] nums = {-9,0,2,2,3};
        int target = 3;
        ThreeSumClosest solution = new ThreeSumClosest();
        int result = solution.threeSumClosest(nums, target);
        System.out.println(result);
    }
}
