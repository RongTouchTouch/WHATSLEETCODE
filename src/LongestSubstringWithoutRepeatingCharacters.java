import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    // 每次判断集合里有没有重复的元素
    // 如果有，就remove到没有为止
    public int lengthOfLongestSubstring(String s) {
        Set<java.lang.Character> set = new HashSet<>();
        int start = 0, max = 0;
        for (int i = 0; i<s.length(); i++)
        {
            if(!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                if (set.size()>max)
                    max = set.size();
            }
            else{
                for (; start<i; start++)
                    if( s.charAt(start)!=s.charAt(i))
                      set.remove(s.charAt(start));
                    else{
                        start++;
                        break;
                    }
            }
        }
        return max;
    }

    // Leetcode官方Solution2，和自己的解法差不多
    // Sliding Window + HashMap的思想
    // 但它写的比我的简洁
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<java.lang.Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    // HashMap + Sliding Window
    // 只用一次遍历√
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<java.lang.Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String agrv[]){
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        int result = solution.lengthOfLongestSubstring("abcabcbc");
        System.out.print(result);
    }
}
