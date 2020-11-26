/***
 * 注意：一定要把>>扩在括号里
 */
public class MergeSort {
    public static void mergesort(int[] nums, int start, int end){
        if(start < end){
            int mid = start + ((end - start)>>1);
            mergesort(nums, start, mid);
            mergesort(nums, mid+1, end);
            merge(nums, start, end, mid);
        }
    }

    public static void merge(int[] nums, int start, int end, int mid){
        if(start == end)
            return;
        int[] cache = new int[end - start+1];
        int i = start, j = mid+1, index = 0;
        while(i <= mid && j <= end){
            if(nums[i] < nums[j])
                cache[index++] = nums[i++];
            else
                cache[index++] = nums[j++];
        }
        while(i<= mid){
            cache[index++] = nums[i++];
        }
        while(j<=end){
            cache[index++] = nums[j++];
        }
        System.arraycopy(cache, 0, nums, start, end-start+1);
    }

    public static void main(String[] args){
        int[] nums = {4,7,2,4,6,8,5,-1,2,4,2,7,3,4,8,1};
        mergesort(nums,0, nums.length-1);
        for (int num : nums)
            System.out.println(num);
    }
}
