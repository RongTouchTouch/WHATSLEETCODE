/*
 * 解法一（错误）
 * https://zhuanlan.zhihu.com/p/67227136 趣谈计算机补码
 * 1.首先考虑暴力解法，使用for循环对每个数取and
 * 2.优化，当result=0时，and的结果必为0，直接返回0
 * 3.特殊情况，当m=2147483646，n=21474836467（2^31-1）时， 程序返回0，正确结果为1，原因在于计算机在存储数字,会把
 *   n=21474836467存为0111 1111 ... 1111 1111，当判断i<=n前，会把i+1变为21474836468，即1000 0000 ... 0000 0000，
 *   但计算机会把它判为负数，也就是-1，此时循环没有停止，会继续运算，直到result=0返回。
 * 4.所以，只需要多加一步，判断i是不是等于21474836467。
 * 5.但是居然Time Limit Exceeded了...吐了，直接不能用了
 */

/*
 * public class RangeBitwiseAnd {
 *     public int rangeBitwiseAnd(int m, int n) {
 *         int result = m;
 *         if (m == Integer.MAX_VALUE)
 *             return m;
 *         for(int i = m+1; i <= n; i++)
 *         {
 *             result &= i;
 *             if(result == 0 || i == Integer.MAX_VALUE)
 *                 break;
 *         }
 *         return result;
 *     }
 *     public static void main(String agrv[]){
 *         int m = 2147483646;
 *         int n = 2147483647;
 *         RangeBitwiseAnd solution = new RangeBitwiseAnd();
 *         int result = solution.rangeBitwiseAnd(m, n);
 *         System.out.println(m&(m+1));
 *
 *     }
 * }
 */

/**
 * 解法二（正确）
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/discuss/56729/Bit-operation-solution(JAVA
 * 1.当两个数为一奇一偶时，最后一位数取and一定为0
 * 2.以此类推，直到m=n
 */
public class RangeBitwiseAnd {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == Integer.MAX_VALUE)
            return m;
        int factor = 1;
        while(m < n){
            m>>=1;
            n>>=1;
            factor<<=1;
        }
        int result = m*factor;
        return result;
    }
    public static void main(String agrv[]){
        int m = 2147483647;
        int n = 2147483647;
        RangeBitwiseAnd solution = new RangeBitwiseAnd();
        int result = solution.rangeBitwiseAnd(m, n);
        System.out.println(result);
    }
}

