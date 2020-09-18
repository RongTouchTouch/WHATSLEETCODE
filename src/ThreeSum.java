import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/***
 * 解法一（正确）
 * 1. 首先给nums排序
 * 2. 总体的思路就是要找到三个数，使他们的和为0，所以要想办法使找到他们的过程尽可能简单，且找到的答案不重复
 * 3. 选用的方法就是固定第一个数的位置，然后在剩下的数里面，分别使用指针想法从头和从尾找剩下两个数
 * 4. 找到后，移动指针跳过重复的数
 */

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new LinkedList<>();
        // index
        for (int i = 0; i < nums.length; i++) {
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                }
                else if (nums[i]+nums[j]+nums[k]>0) {
                    k--;
                }
                else{
                    output.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    for(;j<k && nums[j] == nums[j-1];j++);
                    for(;j<k && nums[k]==nums[k+1] ;k--);
                }
            }
            for(;(i<nums.length-1)&&(nums[i]==nums[i+1]);i++);
        }
        return output;
    }

    public static void main(String agrv[]){
        int[] nums = {1,8,6,2,5,4,8,3,7};
        ThreeSum solution = new ThreeSum();
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println(result);
    }

}
