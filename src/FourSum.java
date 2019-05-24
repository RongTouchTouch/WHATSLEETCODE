import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//4Sum
// O(n^2logn)?
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        for (int i = 0; i < nums.length; i++)
            for (int j = i; j < nums.length; j++)
                for (int k = j; k < nums.length; k++) {
                    if (map.containsKey(target - nums[i] - nums[j] - nums[k]) && i<j &&j<k&& k < map.get(target - nums[i] - nums[j] - nums[k])) {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(target - nums[i] - nums[j] - nums[k]);
                        result.add(temp);
                    }
                }
        return result;
    }
}
