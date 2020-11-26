import java.util.ArrayList;
import java.util.Collections;

/***
 * Index: 1636
 * Difficulty: Easy
 * Related Topic: Sort, Array
 */

public class SortArraybyIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        int[] arrays = new int[201];
        ArrayList<Number> numbers = new ArrayList<>();
        for (int num : nums) arrays[num+100]++;
        for(int i = 0; i < 201; i++)
            if(arrays[i]!=0)
                numbers.add(new Number(i-100, arrays[i]));
        Collections.sort(numbers);
        int[] result = new int[nums.length];
        int count = 0;
        for(Number number: numbers){
            for(int j = count; j < count + number.frequency; j++)
                result[j] = number.value;
            count +=number.frequency;
        }
         return result;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        SortArraybyIncreasingFrequency solution = new SortArraybyIncreasingFrequency();
        int[] result = solution.frequencySort(nums);
        for(int i : result)
            System.out.print(i + " ");
    }
}

class Number implements Comparable{
    int value;
    int frequency = 0;

    public Number(int value, int frequency){
        this.value = value;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Object o) {
        Number n = (Number)o;
        if(this.frequency < ((Number) o).frequency)
            return -1;
        if(this.frequency == ((Number) o).frequency)
            return ((Number) o).value-this.value;
        return 1;
    }
}