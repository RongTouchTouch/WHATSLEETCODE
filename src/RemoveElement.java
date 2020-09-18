/***
 * 由于这里的i多加了1，所以返回length的时候就是i
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++){
            if(nums[j]!=val){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }
    public static void main(String agrv[]){
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        RemoveElement solution = new RemoveElement();
        int result = solution.removeElement(nums, val);
        System.out.println(result);
    }
}
