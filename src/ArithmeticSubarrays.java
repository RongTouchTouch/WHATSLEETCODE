import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * Index: 1630
 * Difficulty: Medium
 * Related Topic: Sort
 */

public class ArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<Boolean>();
        for( int i = 0; i < l.length; i++ ){
            int start = l[i];
            int end = r[i];
            int[] new_nums = Arrays.copyOfRange(nums, start, end+1);
            Arrays.sort(new_nums);
            if(start - end == 0){
                result.add(true);
                break;
            }
            int interval = new_nums[1]-new_nums[0];
            for(int j = 0; j < end-start; j++){
                if(new_nums[j+1] - new_nums[j]!=interval){
                    result.add(false);
                    break;
                }
                if(j == end-start-1){
                    result.add(true);
                }
            }
        }
        return result;
    }
    public static void main(String agrv[]){
        int[] nums = {1,2,3,4,6};
        int[] l = {0}, r = {0};
        ArithmeticSubarrays solution = new ArithmeticSubarrays();
        List<Boolean> result = solution.checkArithmeticSubarrays(nums,l,r);
        for(int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));
    }
}
