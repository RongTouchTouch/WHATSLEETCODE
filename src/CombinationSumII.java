import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/***
 * 多了去重。
 * 用了一种非常蠢的方法去重，就。
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            List<List<Integer>> temp = combinationSum2(Arrays.copyOfRange(candidates, 0, i), target - candidates[i]);
            if (temp == null)
                continue;
            for (List<Integer> temp_list : temp){
                temp_list.add(candidates[i]);
                result.add(temp_list);
            }

        }
        return removeDuplicate(result);
    }

    public List<List<Integer>> removeDuplicate(List<List<Integer>> result){
        HashMap<String,Integer> map = new HashMap<>();
        List<List<Integer>> new_result = new ArrayList<>();
        for (List<Integer> temp : result){
            String index = "";
            for (int i = 0; temp != null && i < temp.size(); i++){
                index = index + temp.get(i) + ",";
                System.out.println(index);
            }
            if(map.get(index)==null){
                map.put(index,1);
                new_result.add(temp);
            }
        }
        return new_result;
    }

    public static void main(String[] args){
        int[] candidate = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        CombinationSumII solution = new CombinationSumII();
        List<List<Integer>> result = solution.combinationSum2(candidate, target);
        System.out.println(result);
    }
}

/***
 * 去重的实现其实还可以通过“下次遍历不从自己开始”。虽然下面这段代码和我上面写的差不多，但区别在于我是先回溯还是先把
 * 重复的元素给过滤掉。其实当时再想一想，把位置调换一下，就也不需要用那么难看的把List转成String再Hash来做了。
 */

//public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//    List<List<Integer>> ans = new ArrayList<>();
//    Arrays.sort(candidates); //排序
//    getAnswer(ans, new ArrayList<>(), candidates, target, 0);
//    return ans;
//}
//
//    private void getAnswer(List<List<Integer>> ans, ArrayList<Integer> temp, int[] candidates, int target, int start) {
//        if (target == 0) {
//            ans.add(new ArrayList<Integer>(temp));
//        } else if (target < 0) {
//            return;
//        } else {
//            for (int i = start; i < candidates.length; i++) {
//                //跳过重复的数字
//                if(i > start && candidates[i] == candidates[i-1]) continue;
//                temp.add(candidates[i]);
//                /*************修改的地方*******************/
//                //i -> i + 1 ，因为每个数字只能用一次，所以下次遍历的时候不从自己开始
//                getAnswer(ans, temp, candidates, target - candidates[i], i + 1);
//                /****************************************/
//                temp.remove(temp.size() - 1);
//            }
//        }
//    }