import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i],1);
        for (int i = 0; i < nums.length; i++)
            if(map.containsKey(target-nums[i])&&(nums[i]!=target-nums[i])){
                int j;
                for (j = 0; j < nums.length; j++) {
                    if (nums[j] == target - nums[i]&&i!=j)
                        return new int[] {i,j};
                }
            }
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String agrv[]){
        TwoSum solution = new TwoSum();
        int[] result = solution.twoSum(new int[] {3,2,4,3},6);
        System.out.print(result[0] + " "+ result[1] );
    }
}
