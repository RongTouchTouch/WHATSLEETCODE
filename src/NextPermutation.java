import java.util.Arrays;

/***
 * 解法一（正确，自己写的）
 * 我的思路是，首先从尾部往前查找是否存在后面的数比前面的数小，如果存在，那说明我可以对这一段数字进行重新排序得到下一个排列
 * 举例：1，3，5，4，2     5，4，3毋庸置疑是不用动的，但是3<5 所以说明下一个排列要改变的位置就是3，然后把后面的数字中比三大的数字替代原来的3，然后剩下的arrays.sort
 * 特殊情况就是逆序排列，一定要在确定index之前做，不然会很麻烦
 * 题目要求constant extra memory， 所以不能暴力破解
 * 虽然做对了，但时间复杂度和空间复杂度都差的离谱 但我的思路竟然和solution里面是一样的！！！！
 *
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == Math.max(nums[i], nums[i + 1])) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        if (flag == true)
        {
            Arrays.sort(nums);
            return;
        }
        for (int i = nums.length-1; i > 0; i--){
            if(nums[i]>nums[i-1]){
                index = i-1;
                break;
            }
        }
        System.out.println(index);

        int[] temp = Arrays.copyOfRange(nums, index, nums.length);
        Arrays.sort(temp);
        for (int i = 0; i < temp.length; i++){
            if (temp[i] > nums[index]){
                int tmp = temp[0];
                temp[0] = temp[i];
                temp[i] = tmp;
                break;
            }
        }
        int[] temp2 = Arrays.copyOfRange(temp, 1, temp.length);
        Arrays.sort(temp2);
        for (int i = 0; i < nums.length; i++)
            if(i < index)
                continue;
            else if (i == index)
                nums[i] = temp[0];
            else
                nums[i] = temp2[i-index-1];
    }

    public static void main(String args[]){
        int[] nums = {4,3,2,1};
        NextPermutation solution = new NextPermutation();
        solution.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++)
            System.out.println(nums[i]);
    }
}

/***
 * 学学人家写的代码
 */

//public class Solution {
//    public void nextPermutation(int[] nums) {
//        int i = nums.length - 2;
//        while (i >= 0 && nums[i + 1] <= nums[i]) {
//            i--;
//        }
//        if (i >= 0) {
//            int j = nums.length - 1;
//            while (j >= 0 && nums[j] <= nums[i]) {
//                j--;
//            }
//            swap(nums, i, j);
//        }
          //他这边思考的比较精妙的地方是，我把比index稍大的数与index互换了之后，其实后面还是降序排列的，所以也可以通过reverse解决
//        reverse(nums, i + 1);
//    }
//    // 对nums进行reverse
//    private void reverse(int[] nums, int start) {
//        int i = start, j = nums.length - 1;
//        while (i < j) {
//            swap(nums, i, j);
//            i++;
//            j--;
//        }
//    }
//    //swap
//    private void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
//}