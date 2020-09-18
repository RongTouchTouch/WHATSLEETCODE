import java.util.*;

/***
 * 思路似乎是和3Sum一样的
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length;){
            for(int j = i + 1; j < nums.length;){
                int k = j + 1, l = nums.length - 1;
                while(k < l){
                    if(nums[k] + nums[l] > target - nums[i] - nums[j])
                        l--;
                    else if(nums[k] + nums[l] < target - nums[i] - nums[j])
                        k++;
                    else{
                        ans.add(Arrays.asList(nums[i],nums[j], nums[k],nums[l]));
                        /* to avoid duplicates */
                        for(int temp = nums[k]; k < l && temp == nums[k]; k++);
                        for(int temp = nums[l]; k < l && temp == nums[l]; l--);
                    }
                }
                /* to avoid duplicates */
                for(int temp = nums[j]; j < nums.length && temp == nums[j]; j++);
            }
            /* to avoid duplicates */
            for(int temp = nums[i]; i < nums.length && temp == nums[i]; i++);
        }

        return ans;
    }

    public static void main(String agrv[]){
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        FourSum solution = new FourSum();
        List<List<Integer>> result = solution.fourSum(nums, target);
        System.out.println(result);
    }

}
