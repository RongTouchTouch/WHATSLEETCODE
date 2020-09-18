public class SearchInsertPosition{
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        int start = 0, end = nums.length - 1;
        while(start < end){
            int mid = (start + end)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        if (nums[start] < target)
            return start + 1;
        else
            return start;
    }
    public static void main(String[] argv){
        int[] nums = {0,1,3,5,6,7,9};
        int target = 0;
        SearchInsertPosition solution = new SearchInsertPosition();
        int result = solution.searchInsert(nums, target);
        System.out.println(result);
    }
}
