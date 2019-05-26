import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new LinkedList<>();
        // index
        for (int i = 0; i < nums.length; i++) {
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                // System.out.println(i+" "+j+" "+k);
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
                    for(;j<k&&nums[j]==nums[j-1];j++);
                    for(;j<k&&nums[k]==nums[k+1];k--);
                }
            }
            for(;(i<nums.length-1)&&(nums[i]==nums[i+1]);i++);
        }
        return output;
    }
}
