import java.util.Stack;

/***
 * Index: 20
 * Difficulty: Easy
 * Related Topic: String, Stack
 */

/***
 * 解法一：（正确）
 * 因为后括号-前括号的值是1或2，所以就这么写了。
 */

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] inputs = s.toCharArray();
        for ( int i = 0; i < inputs.length; i++ ){
            if(!stack.isEmpty() && 2 >= inputs[i] - stack.peek()&& inputs[i] - stack.peek() > 0)
                stack.pop();
            else
                stack.push(inputs[i]);
        }
        return stack.isEmpty();
    }
    public static void main(String[] argv){
        String s = "([})";
        ValidParentheses solution = new ValidParentheses();
        boolean result = solution.isValid(s);
        System.out.println(result);
    }
}
