/***
 * Index: 41
 * Difficulty: Hard
 * Related Topic: Array
 */

/***
 * 解法一：正确
 * 呜呜呜呜能自己想出来真是太好了，但还是在小case上错了3次
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        if(length < 1)
            return 1;
        if(length == 1)
            return nums[0]==1?2:1;
        int[] array = new int[length+1];
        for (int num : nums) {
            if (num <= 0) {
            }
            else if (num <= length)
                array[num] = num;
            else {
            }
        }
        //像这种地方都要特别注意，一般不要从i=1开始，不然会出问题
        for(int i = 1; i <= length; i++){
            if (i != array[i])
                return i;
        }
        return array[length]+1;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3};
        FirstMissingPositive solution = new FirstMissingPositive();
        int result = solution.firstMissingPositive(nums);
        System.out.println(result);
    }
}
