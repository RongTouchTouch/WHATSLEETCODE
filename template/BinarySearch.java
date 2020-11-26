import java.util.ArrayList;

public class BinarySearch {
    
    public int binary_search(int[] nums, int target){
        int start = 0, end = nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                end = mid-1;
            else
                start = mid +1;
        }
        return start;
    }
    public int binary_search(int[] nums, int start, int end, int target){
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                end = mid-1;
            else
                start = mid +1;
        }
        return start;
    }

    public int binary_search_start(ArrayList<Integer> nums, int target){
        int start = 0, end = nums.size()-1;
        while(start<end){
            int mid = (start+end)/2;
            if(nums.get(mid) == target) {
                if(mid != 0 && nums.get(mid-1) == target)
                    end = mid - 1;
                else
                    return mid;
            }
            else if(nums.get(mid) > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }

    public int binary_search_end(ArrayList<Integer> nums, int target){
        int start = 0, end = nums.size()-1;
        while(start<end){
            int mid = (start+end)/2;
            if(nums.get(mid)== target) {
                if(mid != nums.size()-1 && nums.get(mid+1) == target)
                    start = mid + 1;
                else
                    return mid;
            }
            else if(nums.get(mid) > target)
                end = mid - 1;
            else
                start = mid +1;
        }
        return end;
    }
}
