/***
 * Index: 1630
 * Difficulty: Medium
 * Related Topic: Depth-first Search, Breadth-first Search
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/***
 * LC211周赛的第三题，我一开始思路完全错了，这不是一道数组题，而是DFS遍历。
 */
public class LexicographicallySmallestStringAfterApplyingOperations {
    Set<String> set = new HashSet<>();

    public String findLexSmallestString(String s, int a, int b) {
        dfs(s,a,b);
        Iterator<String> iterator = set.stream().iterator();
        String min = s;
        while (iterator.hasNext()){
            String temp = iterator.next();
            if(min.compareTo(temp) > 0)
                min = temp;
        }
        return min;
    }

    public void dfs(String s, int a, int b){
        if(set.contains(s)) {
        }
        else{
            set.add(s);
            dfs(add(s,a),a,b);
            dfs(rotate(s,b),a,b);
        }
    }

    public String add(String s, int a){
        StringBuilder new_s = new StringBuilder();
        for( int j = 0; j < s.length(); j++){ //对a，注意是奇数
            if(j % 2 == 1)
                new_s.append((char) ('0' + (s.charAt(j) - '0' + a) % 10));
            else
                new_s.append(s.charAt(j));
        }
        return  new_s.toString();
    }

    public String rotate(String s, int b){
        StringBuilder new_s = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            int index = (i+b)%s.length();
            new_s.append(s.charAt(index));
        }
        return new_s.toString();
    }

    public static void main(String[] args){
        String s = "43987654";
        int a = 7;
        int b = 3;
        LexicographicallySmallestStringAfterApplyingOperations solution = new LexicographicallySmallestStringAfterApplyingOperations();
        String result = solution.findLexSmallestString(s, a, b);
        System.out.println(result);
    }
}
