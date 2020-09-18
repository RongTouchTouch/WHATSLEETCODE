import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 解法一：递归（正确）
 * 其实我也分不清这到底叫递归还是回溯
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        if(target == 0){
            List<Integer> one = new ArrayList<>();
            result.add(one);
            return result;
        }
        if(candidates.length < 1 || target < candidates[0])
            return result;
        for (int i = candidates.length - 1; i >= 0 ; i--){
            List<List<Integer>> temp = combinationSum(Arrays.copyOfRange(candidates, 0, i+1), target - candidates[i]);
            if (temp == null)
                continue;
            for (List<Integer> temp_list : temp){
                temp_list.add(candidates[i]);
                result.add(temp_list);

            }
        }
        return result;
    }
    public static void main(String[] argv){
        int[] candidate = new int[]{1,2,3,5};
        int target = 7;
        CombinationSum solution = new CombinationSum();
        List<List<Integer>> result = solution.combinationSum(candidate, target);
        System.out.println(result);
    }
}
