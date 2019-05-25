import java.util.*;

//4Sum
// O(n^2logn)?
public class FourSum {
    // 这个是错的。。
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        for (int i = 0; i < nums.length; i++)
            for (int j = i; j < nums.length; j++)
                for (int k = j; k < nums.length; k++) {
                    if (map.containsKey(target - nums[i] - nums[j] - nums[k])) {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(target - nums[i] - nums[j] - nums[k]);
                        result.add(temp);
                    }
                }
        for(int i=0;i<result.size()-1;i++)
        {
            for(int k = 0;k<result.size()-i-1;k++)
            {
                int mark = 0;
                for (int j = 0; j<4 ;j++)
                    if (result.get(i).get(j)!=result.get((i+k)).get(j))
                        mark = 1;
                if (mark==0)
                    result.remove(i);
            }
        }
        return result;
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
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
}
