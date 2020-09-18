/***
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 解法一（正确）
 * 通过二分查找，分别把左右的target找出来。是很简单的思路。（虽然我没想到）
 * Q：如何判断找出来的target是最左边的？
 * A：我原来的思路是，看这个index-1是不是也是target。此时要分两种情况，首先判断index是不是头或尾，是的话直接返回，
 *    不是的话，在判断index-1是否为target。因为经过上一个判断，可以确定index-1也不会越界。
 *
 */
public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int index_start = -1, index_end = -1;
        int flag = -1;
        while(start <= end){
            index_start = (start + end)/2;
            if (nums[index_start] == target){
                flag = 0;
                if (index_start == 0)
                    break;
                else if (nums[index_start-1] == target)
                    end = index_start - 1;
                else
                    break;
            }
            else if(nums[index_start] < target)
                start = index_start + 1;
            else
                end = index_start - 1;
        }
        if (flag == -1)
            return new int[]{-1, -1};

        start = index_start;
        end = nums.length - 1;
        while(start <= end){
            index_end = (start + end)/2;
            if (nums[index_end] == target){
                if (index_end == nums.length - 1)
                    break;
                else if (nums[index_end+1] == target)
                    start = index_end + 1;
                else
                    break;
            }
            else if(nums[index_end] < target)
                start = index_end + 1;
            else
                end = index_end - 1;
        }
        return new int[]{index_start, index_end};
    }
    public static void main(String agrv[]){
        int[] nums = {5,5};
        int target = 5;
        FindFirstandLastPositionofElementinSortedArray solution = new FindFirstandLastPositionofElementinSortedArray();
        int[] result = solution.searchRange(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
