//import java.util.Arrays;
//
///***
// * 我认输了，想了三天没想出来，我唯一的思路就是我知道某一段数据如果数组头小于数组尾，那他一定是顺序排列
// * Your algorithm's runtime complexity must be in the order of O(log n).
// */
//public class SearchinRotatedSortedArray {
//    public int search(int[] nums, int target) {
//        int flag = 0;
//        int temp = nums.length / 2;
//        int end = nums.length - 1;
//        // 如果数组头小于尾，则一定是顺序排列
//        if (target == nums[temp])
//            return temp;
//        // 如果后半有序
//        if (nums[temp] < nums[end]) {
//            if (target < nums[temp])
//                //如果在前半
//                return search(Arrays.copyOfRange(nums, 0, temp), target);
//            else
//                //如果在后半
//                return temp + sorted_search(Arrays.copyOfRange(nums, temp, nums.length), target);
//        }
//        // 如果前半有序
//        else {
//            if (target < nums[temp])
//            //如果在前半
//            return sorted_search(Arrays.copyOfRange(nums, 0, temp), target);
//            else
//            //如果在后半
//                return temp + search(Arrays.copyOfRange(nums, temp, nums.length), target);
//        }
//    }
//
//    public int sorted_search(int[] nums, int target){
//        int temp = nums.length/ 2;
//        if (target == nums[temp]){
//            return temp;
//        }
//        else if (target < nums[temp]){
//            return sorted_search(Arrays.copyOfRange(nums, 0, temp), target);
//        }
//        else {
//            return sorted_search(Arrays.copyOfRange(nums, temp, nums.length), target) + temp;
//        }
//    }
//
//    public static void main(String agrv[]){
//        int[] nums = {4,5,6,7,0,1,2};
//        int target = 2;
//        SearchinRotatedSortedArray solution = new SearchinRotatedSortedArray();
//        int result = solution.search(nums, target);
//        System.out.println(result);
//    }
//}
//

import java.util.Arrays;
import java.util.stream.StreamSupport;

/***
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 解法一
 * 数组的移动，可以转化为(index + bias) % length，所以只要把最小的那个数的下标找出来，就知道bias是多少了
 * Q：对于这个问题，找出最小值和直接找出target有区别吗？
 * A：是不一样的。要找target的话需要用target同时和start和mid比较，然而找出最小值只需要start和mid比较即可。
 * Q：如何找出最小值？
 * A：比如 0 1 2 3 4 5 6 7; 6 7 0 1 2 3 4 5 6; 3 4 5 6 7 0 1 2 基本分为三种情况
 *    比较start < mid 时，发现最小值可能在左半边可能在右半边，故不能选用start和mid比较
 *    比较mid < end时，发现此时一定有最小值在左侧，所以选用mid和end进行判断
 * 找到偏移之后，把偏移代入，然后再进行二分查找。
 *
 * Q：两个while，为什么上面一个是<，下面一个是<=?
 * A：
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while (start < end){
            int mid = (start + end)/2;
            if(nums[mid] < nums[end])
                end = mid;
            else
                start = mid + 1;
        }
        int min_index = start;
        start = 0;
        end = nums.length - 1;
        while(start <= end){
            int mid = (start + end)/2;
            int mid_changed = (mid + min_index) % nums.length;
            if(nums[mid_changed] == target)
                return mid_changed;
            else if ( target > nums[mid_changed] )
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    public static void main(String agrv[]){
        int[] nums = {4,5,6,7,0,1,2};
        int target = 7;
        SearchinRotatedSortedArray solution = new SearchinRotatedSortedArray();
        int result = solution.search(nums, target);
        System.out.println(result);
    }
}

