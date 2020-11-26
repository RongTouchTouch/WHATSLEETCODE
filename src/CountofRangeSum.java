import java.util.Arrays;

/***
 * Index: 327
 * Difficulty: Hard
 * Related Topic: Binary Search, Divide and Conquer, Sort, Binary Indexed Tree, Segment Tree
 */

/***
 * 解法一：Binary Indexed Tree
 * (我一定要把这一类型搞透)
 * 其实我很早就想出了query(sum[i]+upper) - query(sum[i]+lower)，但一直没从前缀和的问题上绕出来。
 * 1.以nums = {-2,5,-1}为例，sum = {0,-2,3,-2}，为前缀和，我原先一直想不通，这样不是每次都是从0开始计算嘛，那我想取区间[2,2]
 * 得到-1怎么做呢？
 * 但事实上，我已经通过+upper和+lower的操作，把我想要在[2,2]上取得[lower,upper]的值，变成了在[0,1]上取得[sum[i]+lower,sum[i]+upper]
 * 也就是，sum[3]=-1，-1在[-3,1]的区间内，其实这里就是在计算num[2]也就是-1满足[-2,2]，所以count++。
 * 2.为什么可以对sum数组进行排序，排序之后，里面有所有的前缀和，那我怎么知道我的i会不会取到比i大的数对应的前缀和呢？就比如sum = {0,-2,3,-2}，
 * 排序后sorted_sum = {-2,-2,0,3}，那有一个-2是针对[0,2]的，那我在对第一个-2进行操作的时候会不会取到第2个呢。
 * 首先要想清楚，要进行遍历的元素是什么？是sum[i]还是num[i]？我们在上一个问题中已经解决了为什么前缀和是可行的问题，所以答案肯定是sum[i]。
 * 那么，对sum[i]进行遍历的要求是什么？我对sum[0]进行遍历的时候，其实就是告诉你前缀和是0，其实就是以num[0]开头的所有情况，所以我的range还是[-2,2]，
 * 那么这时sorted_sum中有两个-2，所以count+2。然后我们以0开头的可能性已经完成了，那我们就把0从bit中移除就可以了。（注意移除要在最先做）
 * 这么想，“i会不会取到比i大的数对应的前缀和”这个问题本身就有问题，因为我们的范围是越来越小的。
 * 3.bit的实现？
 * 两点，一点是以index形式实行，还有一点就是包含sum[i]。
 *
 * 我想我终于理解这道题应该怎么用BIT来做了。。说实话BIT真的不是解题的最好方法，最好用分治。
 * 对我而言，可能理解怎么运用好BIT还是有点难吧。
 * 现在做过的两道，一道是ReversePair，还有一道就是这个。
 * 首先两道题的共同点：
 * 1. bit中存的是什么？往往是index，因为前缀和有可能是负的，而且值的波动范围大，使用index可以有效限制bit的大小。
 * 2. 它是如何缩小题目的规模的？ 。。。。暂时想不出比较general的解释。
 *
 * 这道题里还有几点要注意的是：
 * 1. sorted_sums里面应该加上sum[i]+upper和sum[i]+lower，这样才能index
 * 2. 应该用sums[i] + lower - 1，因为bit的query是闭空间。
 * 3. 保险起见sum要用long
 */
public class CountofRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length+1];
        long[] sorted_sums = new long[sums.length*3+1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i+1] += sums[i] + nums[i];
            sorted_sums[index++] = sums[i];
            sorted_sums[index++] = sums[i] + upper;
            sorted_sums[index++] = sums[i] + lower - 1;
        }
        sorted_sums[index] = Integer.MAX_VALUE;
        Arrays.sort(sorted_sums);
        BinaryIndexedTree bit = new BinaryIndexedTree(sorted_sums.length+1);
        for(int i = 0; i < sums.length; i++){
            bit.update(index(sorted_sums,sums[i])+1, 1);
        }
        int count = 0;
        for(int i = 0; i < sums.length; i++){
            bit.update(index(sorted_sums,sums[i])+1,-1);
            count += bit.query(index(sorted_sums,sums[i]+upper)+1)-bit.query(index(sorted_sums,sums[i]+lower-1)+1);
        }
        return count;
    }

    private int index(long[] array, long val) {
        int start = 0, end = array.length-1, mid;
        while(start <= end) {
            mid = start + ((end - start)>>1);
            if(array[mid] >= val)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }

    public static void main(String[] args){
        int[] nums = {-2,5,-1};
        int lower = -2;
        int upper = 2;
        CountofRangeSum solution = new CountofRangeSum();
        int result = solution.countRangeSum(nums, lower, upper);
        System.out.println(result);
    }
}
