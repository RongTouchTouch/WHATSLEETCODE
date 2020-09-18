/***
 * Index: 5
 * Difficulty: Medium
 * Related Topic: String, Dynamic Programming
 */

/***
 * 解法一：中心扩展（正确）
 * 分奇偶解决问题。
 * WA过一次，原因是我用if (characters[i] == characters[i + 1])来判断是进奇数循环还是偶数循环，但是如果是“ccc”的话，
 * 就不应该只进偶数。
 *
 * 自己写的果然还是很难看，这道题有非常多的解法，乘机复习一下动态规划。
 * 像这样两端差不多的代码，可以新建一个函数。
 *
 * 注意substring(start_index,end_index+1)
 */
//public class LongestPalindromicSubstring{
//    public String longestPalindrome(String s) {
//        char[] characters = s.toCharArray();
//        String result = s.substring(0,0);
//        for ( int i = 0;i < characters.length-1; i++ ) {
//            if (characters[i] == characters[i + 1]) {
//                // 像这种地方可以用一个while解决
//                for (int k = 0; i - k >= 0 && i + 1 + k <= characters.length - 1; k++) {
//                    if (characters[i - k] == characters[i + k + 1]) {
//                        if (2 * (k+1)  > result.length()) {
//                            result = s.substring(i - k , i + k + 2);
//                            System.out.println(result);
//                        }
//                    }
//                    else
//                        break;
//                }
//            }
//                for (int k = 0; i - k >= 0 && i + k <= characters.length - 1; k++) {
//                    if (characters[i - k] == characters[i + k]) {
//                        if (2 * k +1> result.length()) {
//                            result = s.substring(i - k, i + k + 1);
//                            System.out.println(i);
//                            System.out.println(result);
//                        }
//                    }
//                    else
//                        break;
//                }
//            }
//
//        return result;
//    }
//
//    public static void main(String args[]){
//        String s = "ccc";
//        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
//        String result = solution.longestPalindrome(s);
//        System.out.println(result);
//    }
//}

/***
 * 中心扩展ver2
 */

//    public String longestPalindrome(String s) {
//        if (s == null || s.length() < 1) return "";
//        int start = 0, end = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int len1 = expandAroundCenter(s, i, i);
//            int len2 = expandAroundCenter(s, i, i + 1);
//            int len = Math.max(len1, len2);
//            if (len > end - start) {
//                start = i - (len - 1) / 2;
//                end = i + len / 2;
//            }
//        }
//        return s.substring(start, end + 1);
//    }
//
//    private int expandAroundCenter(String s, int left, int right) {
//        int L = left, R = right;
//        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
//            L--;
//            R++;
//        }
//        return R - L - 1;
//    }


/***
 * 解法二：动态规划
 * 矩阵思路
 * 但我的动态规划比我上一个算法要慢得多。。时间和空间都在后85%左右
 * 我上一个算法时间可是前5%。。
 */

//public class LongestPalindromicSubstring{
//    public String longestPalindrome(String s) {
//        if (s == null || s.length() < 1) return "";
//        int[][] matrix = new int[s.length()][s.length()];
//        String result = "";
//        for (int i = s.length()-1; i >= 0; i-- ){
//            for( int j = i; j < s.length(); j++ ){
//                if( i == j )
//                    matrix[i][j] = 1;
//                else if (i == j-1 && s.charAt(i) == s.charAt(j))
//                    matrix[i][j] = 2;
//                else if(s.charAt(i) == s.charAt(j) && matrix[i+1][j-1]!=0) {
//                    matrix[i][j] = matrix[i + 1][j - 1] + 2;
//                }
//                else
//                    matrix[i][j] = 0;
//                if(matrix[i][j]>result.length())
//                    result = s.substring(i, j+1);
//            }
//        }
//        return result;
//    }
//
//    public static void main(String args[]){
//        String s = "bababbabc";
//        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
//        String result = solution.longestPalindrome(s);
//        System.out.println(result);
//    }
//}


public class LongestPalindromicSubstring{
    public String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        String ret = "^";
        for (int i = 0; i < n; i++)
            ret += "#" + s.charAt(i);
        ret += "#$";
        return ret;
    }

    // 马拉车算法
    public String longestPalindrome(String s) {
        String T = preProcess(s);
        int n = T.length();
        int[] P = new int[n];
        int C = 0, R = 0;
        for (int i = 1; i < n - 1; i++) {
            int i_mirror = 2 * C - i;
            if (R > i) {
                P[i] = Math.min(R - i, P[i_mirror]);// 防止超出 R
            } else {
                P[i] = 0;// 等于 R 的情况
            }

            // 碰到之前讲的三种情况时候，需要利用中心扩展法
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            // 判断是否需要更新 R
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }

        }

        // 找出 P 的最大值
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2; //最开始讲的求原字符串下标
        return s.substring(start, start + maxLen);
    }

    public static void main(String args[]){
        String s = "bababbabc";
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String result = solution.longestPalindrome(s);
        System.out.println(result);
    }
}

