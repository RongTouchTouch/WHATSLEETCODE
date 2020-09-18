import java.util.ArrayList;
import java.util.HashMap;

/***
 * Index: 13
 * Difficulty: Easy
 * Related Topic: Math, String
 */

/***
 * 解法一：（正确）
 * 规律就是，只要右边一位比左边的大，说明左边的是减。
 */
public class RomantoInteger {
    public int romanToInt(String s) {
        int result = 0;
        char[] romans = s.toCharArray();
        HashMap<Character, Integer> order = new HashMap<>();
        order.put('I', 1);
        order.put('V', 5);
        order.put('X', 10);
        order.put('L', 50);
        order.put('C', 100);
        order.put('D', 500);
        order.put('M', 1000);
        for ( int i = 0; i < romans.length; i++) {
            int sign = 1;
            if (i < romans.length - 1 &&  order.get(romans[i+1])> order.get(romans[i]))
                sign = -1;
            int value = order.get(romans[i]);
            result += sign * value;
        }
        return result;
    }
    public static void main(String[] argv){
        String roman = "MCMXCIV";
        RomantoInteger solution = new RomantoInteger();
        int result = solution.romanToInt(roman);
        System.out.println(result);
    }
}
