/***
 * Index: 28
 * Difficulty: Easy
 * Related Topic: String
 */

/***
 * 解法一：
 * 这道题是真的把我搞崩溃了，一道题WA了5次
 * 有时候真的不能偷懒是想着跳过一些步骤，还是得好好写
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(needle.length()<1)
            return 0;
        if(haystack.length()<1||haystack.length()<needle.length())
            return -1;
        for(int i = 0; i < haystack.length(); i++){
            for( int j=0; j < needle.length();j++){
                if(i+j==haystack.length())
                    return -1;
                if(haystack.charAt(i+j)!=needle.charAt(j))
                    break;
                if(j==needle.length()-1)
                    return i;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        String haystack = "mississippi";
        String needle = "issi";
        ImplementStrStr solution = new ImplementStrStr();
        int result = solution.strStr(haystack, needle);
        System.out.println(result);
    }
}
