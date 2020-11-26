import java.util.*;

/***
 * Index: 315
 * Difficulty: Hard
 * Related Topic: Binary Search, Divide and Conquer, Sort, Binary Indexed Tree, Segment Tree
 */

public class CountofSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new LinkedList<>();
        int[] sorted_nums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted_nums);
        BinaryIndexedTree bit = new BinaryIndexedTree(nums.length+1);
        for(int i = nums.length-1; i >= 0; i--){
            result.add(bit.query(index(sorted_nums,nums[i])));
            bit.update(index(sorted_nums,nums[i])+1,1);
        }
        Collections.reverse(result);
        return result;
    }

    private int index(int[] array, long val) {
        int start = 0, end = array.length-1, mid;
        while(start <= end) {
            mid = start + ((end - start)>>1);
            if(array[mid] >= val)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }
}
