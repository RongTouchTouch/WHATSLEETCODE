import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/***
 * Index: 22
 * Difficulty: Medium
 * Related Topic: String, Backtracking
 */

/***
 * 解法一：回溯（正确）
 */
//public class GenerateParentheses {
//    public List<String> generateParenthesis(int n) {
//        if( n==1 ){
//            List<String> result = new LinkedList<>();
//            result.add("()");
//            return result;
//        }
//        else{
//            List<String> result = new LinkedList<>();
//            for(String s : generateParenthesis(n-1)){
//                int length = s.toCharArray().length;
//                for ( int i = 0; i < length; i++)
//                    result.add(s.substring(0, i) + "()"+s.substring(i, s.length()));
//            }
//            List<String> newresult = new LinkedList<>();
//            HashMap<String, Integer> map = new HashMap<>();
//            for(String s : result){
//                if(map.get(s)==null){
//                    map.put(s, 1);
//                    newresult.add(s);
//                }
//            }
//            return newresult;
//        }
//    }
//    public static void main(String[] args){
//        int n = 3;
//        GenerateParentheses solution = new GenerateParentheses();
//        List<String> result = solution.generateParenthesis(n);
//        for(String s : result)
//            System.out.println(s);
//    }
//}

/***
 * 解法二：别人的回溯（正确）
 * 比我效率高了400%，我还是没学到回溯的精髓。
 *
 * 这里有一点我没想到的是：
 * 只要左边的括号比右边的括号多，那就是valid的。
 *
 * 这种回溯的要点有两个：
 * 1. 把返回列表放在参数里，方便return前存下结果。
 * 2. return为空，所以返回后会继续往后执行，这一点一定要理解。
 *
 */

class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }
    public static void main(String[] args){
        int n = 3;
        GenerateParentheses solution = new GenerateParentheses();
        List<String> result = solution.generateParenthesis(n);
        for(String s : result)
            System.out.println(s);
    }
}

/***
 *  解法三：公式法
 *  要想到它能以（...）...的形式推算。
 */
//class GenerateParentheses  {
//    public List<String> generateParenthesis(int n) {
//        List<String> ans = new ArrayList();
//        if (n == 0) {
//            ans.add("");
//        } else {
//            for (int c = 0; c < n; ++c)
//                for (String left: generateParenthesis(c))
//                    for (String right: generateParenthesis(n-1-c))
//                        ans.add("(" + left + ")" + right);
//        }
//        return ans;
//    }
//}