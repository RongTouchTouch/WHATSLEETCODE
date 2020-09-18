/***
 * 解法一：递归（超时）
 * 想象n的情况就是在一个根节点上把剩下的n-1个节点在它左右两边放上去。
 * 其实只要稍微改进一下把前面几个的结果存下来就好了。
 */
public class UniqueBinarySearchTrees {
//    public int numTrees(int n) {
//        int result = 0;
//        if (n == 0 || n == 1)
//            return 1;
//        if (n >= 2){
//            for (int i = 0; i < n; i++)
//                result +=numTrees(i) * numTrees(n-i-1);
//        }
//        return result;
//    }
    public int numTrees(int n) {
        int[] nums = new int[20];
        nums[0] = 1;
        nums[1] = 1;
        for (int k = 2; k <= n; k++ ){
            for (int i = 0; i < k; i++)
                nums[k] +=nums[i] * nums[k-i-1];
        }
        return nums[n];
    }
    public static void main(String[] argv){
        UniqueBinarySearchTrees solution = new UniqueBinarySearchTrees();
        int result = solution.numTrees(19);
        System.out.println(result);
    }
}
