/***
 * 解法一（正确）
 * 没什么需要注意的
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int temp = 0;
        int origin = x;
        while(x > 0){
            temp = 10*temp + x % 10;
            x/=10;
        }
        return temp == origin;
    }
    public static void main(String agrv[]){
        int x = 10100101;
        PalindromeNumber solution = new PalindromeNumber();
        boolean result = solution.isPalindrome(x);
        System.out.println(result);
    }
}
