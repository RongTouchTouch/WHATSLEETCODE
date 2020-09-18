/**
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
 * range: [−2^31,  2^31 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1)
 * or INT_MIN (−231) is returned.
 */

/**
 * 解法一（正确，自己写的）
 * 1. 需要注意的是对有效数字，符号（+和-），越界的判断。
 * 2. 关于越界的判断，可以先使用long，再在返回时转回int
 */


public class StringtoInteger {
    public int myAtoi(String str) {
        long result = 0;
        int sign = 0;
        boolean empty = true;
        for (int i = 0; i < str.length(); i++ ){
            char nums = str.charAt(i);
            if(nums>='0' && nums<='9') {
                result = result * 10 + nums - '0';
                empty = false;
                if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ){
                    if (sign == 1)
                        result = Integer.MIN_VALUE;
                    else
                        return Integer.MAX_VALUE;
                }
            }
            else if (nums == '-' && empty) {
                sign = 1;
                empty = false;
            }
            else if (nums == '+' && empty){
                sign = 0;
                empty = false;
            }
            else if (nums == ' ' && empty)
                continue;
            else
                break;
        }
        if (sign == 1)
            result = result * -1;
        return (int)result;
    }

    public static void main(String[] args){
        StringtoInteger solution = new StringtoInteger();
        String input = "-912834   72332";
        int result = solution.myAtoi(input);
        System.out.print(result);
    }
}
