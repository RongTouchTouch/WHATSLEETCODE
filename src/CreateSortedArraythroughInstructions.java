import java.util.ArrayList;

/***
 * Index: 1649
 * Difficulty: Hard
 * Related Topic: Binary Indexed Tree, Segment Tree, Ordered Map
 */

/***
 * 解法一：二分查找（正确）
 */
public class CreateSortedArraythroughInstructions {
    public int createSortedArray(int[] instructions) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        long sum = 0;
        for (int instruction : instructions) {
            if (arrayList.size() < 1)
                arrayList.add(instruction);
            else {
                int index = binary_search(arrayList, instruction);
                if (index < arrayList.size() && arrayList.get(index) == instruction) {
                    arrayList.add(index, instruction);
                    int[] temp = search_range(arrayList, instruction);
                    sum += Math.min(temp[0], arrayList.size() - 1 - temp[1]);
                } else {
                    arrayList.add(index, instruction);
                    sum += Math.min(index, arrayList.size() - 1 - index);
                }
            }
        }
        return (int)(sum%1000000007);
    }

    public int binary_search(ArrayList<Integer> nums, int target){
        int start = 0, end = nums.size()-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums.get(mid) == target)
                return mid;
            else if(nums.get(mid) > target)
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

    public int[] search_range(ArrayList<Integer> nums, int target){
        int[] result = new int[2];
        result[0] = binary_search_start(nums, target);
        result[1] = binary_search_end(nums, target);
        return result;
    }

    public static void main(String[] args){
        int[] instructions = {1,2,3,6,5,4};
        CreateSortedArraythroughInstructions solution = new CreateSortedArraythroughInstructions();
        int result = solution.createSortedArray(instructions);
        System.out.println(result);
    }
}


/***
 * 解法二：树状数组
 * 新学的算法，太妙了555
 */
class CreateSortedArraythroughInstructions2 {
    public int createSortedArray(int[] instructions) {
        BIT bit = new BIT(100001);
        long sum = 0;
        for(int i = 0 ; i <  instructions.length; i++){
            bit.add(instructions[i] , 1);
            int l = bit.query(instructions[i] - 1);
            int r = i + 1 - bit.query(instructions[i]);
            sum += Math.min(l,r);
        }
        return (int) (sum % 1000000007);
    }

    public static void main(String[] args){
        int[] instructions = {1,5,6,2};
        CreateSortedArraythroughInstructions2 solution = new CreateSortedArraythroughInstructions2();
        int result = solution.createSortedArray(instructions);
        System.out.println(result);
    }
}

class BIT {
    int[] bit;
    BIT(int n) {
        bit = new int[n+1];
    }

    // Queries the closed range [0, i]
    int query(int i) {
        i++;
        int sum = 0;
        while (i >= 1) {
            sum += bit[i];
            i -= i & -i;
        }
        return sum;
    }

    void add(int i, int value) {
        i++;
        while (i < bit.length) {
            bit[i] += value;
            i += i & -i;
        }
    }
}
