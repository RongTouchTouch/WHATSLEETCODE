/***
 * 解法一（正确）
 * 不是很难，两个指针的思路。
 * 唯一值得注意的是判断完nums[i]和nums[j]以后，先移动i，再进行赋值。
 * 而且，由于这里的i记录的是最后一个有效下标，所以返回length的时候要+1.
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }

    public static void main(String agrv[]){
        int[] nums = {1,1,2};
        RemoveDuplicates solution = new RemoveDuplicates();
        int result = solution.removeDuplicates(nums);
        System.out.println(result);
    }
}
