import java.util.HashMap;
import java.util.Map;

/***
 * Index: 1624
 * Difficulty: Easy
 * Related Topic: String
 */

public class LargestSubstringBetweenTwoEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<java.lang.Character, Integer> map = new HashMap<>();
        int result = -1;
        for( int i = 0; i < s.length(); i++ ){
            if (map.get(s.charAt(i)) == null)
                map.put(s.charAt(i),i+1);
            else{
                if( i - map.get(s.charAt(i))> result )
                    result = i - map.get(s.charAt(i));
            }
        }
        return result;
    }

    public static void main(String agrv[]){
        String s = "basdaqfb";
        LargestSubstringBetweenTwoEqualCharacters solution = new LargestSubstringBetweenTwoEqualCharacters();
        int result = solution.maxLengthBetweenEqualCharacters(s);
        System.out.println(result);
    }
}
