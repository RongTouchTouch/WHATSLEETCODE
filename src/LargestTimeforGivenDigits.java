import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * Index: 949
 * Difficulty: Easy
 * Related Topic: Math
 *
 * Problem Description:
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 *
 */

/***
 * 解法一：全排列（正确)
 * 唯一的难点在于如何写出全排列。借鉴了网上代码，写的很巧妙。
 * 然后注意一下时间的输出，要加0。
 * 还有就是String.format可以直接改格式，老笨b了。
 */
public class LargestTimeforGivenDigits {
    public static void arrange(int array[], int start, int end, List<Integer> result){
        if( start == end ){
            int temp = 1000*array[0] + 100*array[1] + 10*array[2] + array[3];
            result.add(temp);
        }
        else{
            for( int i = start; i <= end; i++){
                swap(array, start, i);
                // start + 1 很关键！
                arrange(array, start+1, end, result);
                swap(array, i, start);
            }
        }
    }

    public static void swap(int array[], int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public String largestTimeFromDigits(int[] array) {
        String result = "";
        List<Integer> nums = new ArrayList<>();
        arrange(array, 0, array.length-1, nums);
        int max = -1;
        for( int num : nums ){
            if(num / 100 < 24 && num % 100 <= 59){
                if(num > max)
                    max = num;
            }
        }
        if(max == -1)
            return "";
//        if(max/100<10)
//            result = "0" + max/100;
//        else
//            result = "" + max/100;
//        result += ":";
//        if(max%100<10)
//            result += "0" + max%100;
//        else
//            result += max%100;
        else
            result = String.format("%02d:%02d", max / 100, max % 100);

        return result;
    }

    public static void main(String args[]){
        int array[] = {1,2,3,4};
        LargestTimeforGivenDigits solution = new LargestTimeforGivenDigits();
        String result = solution.largestTimeFromDigits(array);
        System.out.println(result);
    }
}
