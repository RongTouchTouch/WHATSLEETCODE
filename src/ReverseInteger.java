/**
 * 解法一（正确，自己写的，很难看）：
 * 把数字拆解一个个读到数组里，然后再组成新数，看起来很复杂！
 */
/*
public class ReverseInteger {
        public long times(int x){
        int result = 1;
        for (int i = 0; i < x; i++)
            result = 10 * result;
        return result;
    }
    public int reverse(int x) {
        int end = 0;
        int[] digits = new int[10];
        for (int i = 0; x!= 0; i++) {
            digits[i] = x % 10;
            x /=10;
            end = i;
        }
        int start = 0;
        for (int i = 0; i < digits.length; i ++) {
            if (digits[i] == 0)
                start++;
            else
                break;
        }
        long result = 0;
        for (int i = end; i >= start; i--){
            result+=digits[i]*times(end-i);
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ) return 0;
        else
            return (int)result;
    }
    public static void main(String agrs[]){
        ReverseInteger solution = new ReverseInteger();
        int input = -534236469;
        int result = solution.reverse(input);
        System.out.print(result);
    }
}
*/

/**
 * 解法二：
 * 1.在讲原数字取模的同时，对新数字进行result*10+num
 * 2.考虑特殊情况，负数，或者有些数字反过来之后可能会越界！
 */

public class ReverseInteger {
    public int reverse(int x) {
        long rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            rev = rev * 10 + pop;
        }
        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE ) return 0;
        return (int)rev;
    }
    public static void main(String agrs[]){
        ReverseInteger solution = new ReverseInteger();
        int input = -534236469;
        int result = solution.reverse(input);
        System.out.print(result);
    }
}
