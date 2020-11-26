/***
 * Index: 493
 * Difficulty: Hard
 * Related Topic: Binary Search, Divide and Conquer, Sort, Binary Indexed Tree, Segment Tree
 */

import java.util.Arrays;

/***
 * 解法一：树状数组（正确）
 * https://leetcode.com/problems/reverse-pairs/discuss/97268/General-principles-behind-problems-similar-to-%22Reverse-Pairs%22
 */
public class ReversePairs{
    public int reversePairs(int[] nums) {
        int sum = 0;
        int[] sorted_nums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted_nums);
        BinaryIndexedTree binaryIndexedTree = new BinaryIndexedTree(50001);
        for(int i = 0 ; i < nums.length; i++){
            sum += i - binaryIndexedTree.query(index(sorted_nums,2L * nums[i] + 1)); // 得到的应该是大于2x+1的数的个数
            binaryIndexedTree.update(index(sorted_nums,nums[i]) + 1,1);
        }
        return sum;
    }
    private int index(int[] array, long val) {
        int start = 0, end = array.length - 1, mid;
        while(start <= end) {
            mid = start + ((end - start)>>1);
            if(array[mid] >= val)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
        }


    public static void main(String[] args){
        int[] nums = {1,3,2,3,1};
        ReversePairs solution = new ReversePairs();
        int result = solution.reversePairs(nums);
        System.out.println(result);
    }
}

/***
 * 解法二：mergesort（正确）
 * 思路：分治。分治的思路是把一个问题拆分成两个子问题，子问题是原问题规模的一半。
 * 即，F(0, nums.length) = F(0, nums.length/2) + F (nums.length/2, nums.length) + C
 * 就本题而言，C的意义为，从[0, nums.length/2]中取i，从[nums.length/2, nums.length]取j，(i, j)构成important reverse pairs
 * 为了更方便的求解C，我们可以对这两个数组分别做一些处理，比如使他们变成排序数组。举例两个数组分别排完序后变成[5,7,8,9]与[1,2,3,6]
 * 因为我们总能在O(n)的时间中计算出C，剩下的就按照mergesort将两个数组排成一个就好了。
 */
class ReversePairs2 {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length);
    }

    int mergeSort(int[] nums, int lo, int hi){
        if (lo>=hi-1) return 0;
        int mid = lo+(hi-lo)/2;
        int res = mergeSort(nums, lo, mid) + mergeSort(nums, mid, hi);
        int i = lo, j = mid, k = mid, idx = 0, cnt = 0;
        int[] cache = new int[hi-lo];
        while (i<mid){
            //这边cnt++和res+=cnt很精髓，避免了重置j的麻烦
            while (j<hi && (long)nums[j]*2<(long)nums[i]){
                j++;
                cnt++;
            }
            res+=cnt;
            while (k<hi && nums[i]>nums[k]){
                cache[idx++] = nums[k++];
            }
            cache[idx++] = nums[i++];
        }
        System.arraycopy(cache, 0, nums, lo, idx);
        return res;
    }

    public static void main(String[] args){
        int[] nums = {1,3,2,3,1};
        ReversePairs2 solution = new ReversePairs2();
        int result = solution.reversePairs(nums);
        System.out.println(result);
    }
}