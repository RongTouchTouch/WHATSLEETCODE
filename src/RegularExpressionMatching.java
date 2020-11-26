/***
 * Index: 10
 * Difficulty: Hard
 * Related Topic: String, Dynamic Programming, Backtracking
 */

/***
 * 解法一：动态规划
 * 这道题用动态规划的思路说实话刷新了我对动态规划的理解。
 * 1. dp数组的设计，用的是boolean[s.length()+1][p.length()+1]，其实和之前有一道listnode加了个dummy很像
 * 2. 第一个for循环，判断p能不能形成s=""的形式
 * 3. 第二个for循环，首先判断一下单个的，然后再判断通配符。
 *    通配符的判断分为两种，一种是通配符前一个字符和文本不对应的（就是有可能不指代任何字符），还有一种是对应的。
 * 发现了动态规划的巧妙。
 */

//public class RegularExpressionMatching {
//    public boolean isMatch(String s, String p) {
//        if(s == null || p == null)
//            return false;
//        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
//        dp[0][0] = true;
//        for(int i = 0; i < p.length(); i ++){
//            if((p.charAt(i)=='*') && (dp[0][i-1]))
//                dp[0][i+1] = true;
//        }
//        for(int i  = 0; i < s.length(); i++){
//            for(int j = 0; j < p.length(); j++){
//                if(s.charAt(i) == p.charAt(j))
//                    dp[i+1][j+1] = dp[i][j];
//                if(p.charAt(j) == '.')
//                    dp[i+1][j+1] = dp[i][j]; //????
//                if (p.charAt(j) == '*') {
//                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
//                        dp[i+1][j+1] = dp[i+1][j-1];
//                    } else {
//                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
//                    }
//                }
//            }
//        }
//
//        for (int i  = 0; i <= s.length(); i++){
//            for(int j = 0; j <= p.length(); j++){
//                System.out.print(dp[i][j]+" ");
//            }
//                System.out.println();
//        }
//
//        return dp[s.length()][p.length()];
//
//    }
//    public static void main(String args[]){
//        String s = "aab";
//        String p = "c*a*b";
//        RegularExpressionMatching solution = new RegularExpressionMatching();
//        boolean result = solution.isMatch(s, p);
//        System.out.println(result);
//    }
//}

/***
 * 解法二：递归
 * 参考了《剑指offer》
 *
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null)
            return false;
        return matchCore(s, p);
    }

    public boolean matchCore(String s, String p) {
        if ( s.length() == 0 && p.length() == 0)
            return true;
        if ( s.length() != 0 && p.length() == 0 )
            return false;
        if ( p.length() <=1 || p.charAt(1)!='*' ) { //越界怎么办
            if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))
                return matchCore(s.substring(1), p.substring(1));
            else
                return false;
        }
        else {
            if (s.charAt(0) != p.charAt(0))
                return matchCore(s, p.substring(2));
            else{
                return matchCore(s.substring(1), p.substring(2)) || matchCore(s.substring(1), p);
            }
        }
    }

    public static void main(String args[]){
        String s = "aab";
        String p = "c*aaa*b";
        RegularExpressionMatching solution = new RegularExpressionMatching();
        boolean result = solution.isMatch(s, p);
        System.out.println(result);
    }
}
