/***
 * Index: 42
 * Difficulty: Hard
 * Related Topic: Array, Greedy
 */

/***
 * 解法一：（超时）
 * 其实不该抱着侥幸的心理交的。。
 * 在Jump Game的基础上多了最少步数
 */
//public class JumpGameII {
//    public int jump(int[] nums) {
//        int[] temp = new int[nums.length];
//        temp[0] = 1;
//        for (int i = 0; i < nums.length; i++) {
//            if (temp[i]>0)
//                for (int j = 1; j <= nums[i] && i+j < nums.length; j++)
//                    temp[i + j] = temp[i+j]>0 ? Math.min(temp[i]+1, temp[i+j]):temp[i]+1;
//        }
//        return temp[nums.length - 1] - 1;
//    }
//
//    public static void main(String[] args){
//        int[] nums = {2,2,3,1,5,6,0,2,3,4,1,3,1,0,1,1,1,2,0,4};
//        JumpGameII solution = new JumpGameII();
//        int result = solution.jump(nums);
//        System.out.println(result);
//    }
//}

/***
 * 解法二：（正确）
 * 虽然速度还是很慢，291 ms, faster than 19.97%，但挣扎了很久还是想出了一种方法来解决。。还好没放弃
 */
//public class JumpGameII {
//    public int jump(int[] nums) {
//        int lastPos = nums.length-1;
//        int count = 0;
//        while(lastPos!=0) {
//            int min_i = lastPos;
//            for (int i = lastPos; i >= 0; i--) {
//                if (i + nums[i] >= lastPos)
//                    min_i = i;
//            }
//            lastPos = min_i;
//            count++;
//        }
//        return count;
//    }
//
//    public static void main(String[] args){
//        int[] nums = {2,2,3,1,5,6,0,2,3,4,1,3,1,0,1,1,1,2,0,4,1,1,2,4,0,0,2,3,5,10,2,5,2,1,0,5,7,2};
//        JumpGameII solution = new JumpGameII();
//        int result = solution.jump(nums);
//        System.out.println(result);
//    }
//}
/***
 *  解法三：（正确）
 *  抄了一个1ms的算法。
 *  解法二我用的是从后往前找，反之从前往后找也是成立的。
 *  他这里pos==i的判断真的很绝，pos==1说明这是上一个i+num[i]到下一个i+num[i]能达到的最远的距离了
 *  好妙啊呜呜呜
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int pos = 0, des = 0;
        int count = 0;

        for(int i = 0;i < nums.length-1;i++){
            des = Math.max(des, i+nums[i]);
            if(pos == i){
                pos = des;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        int[] nums = {2,2,3,1,5,6,0,2,3,4,1,3,1,0,1,1,1,2,0,4,1,1,2,4,0,0,2,3,5,10,2,5,2,1,0,5,7,2};
        JumpGameII solution = new JumpGameII();
        int result = solution.jump(nums);
        System.out.println(result);
    }
}