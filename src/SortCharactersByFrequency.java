import java.util.ArrayList;
import java.util.Collections;

/***
 * Index: 451
 * Difficulty: Medium
 * Related Topic: Sort, Array
 */

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        int[] arrays = new int[256];
        ArrayList<Character1> characters = new ArrayList<>();
        for (char c: s.toCharArray()) arrays[c]++;
        for(int i = 0; i < 201; i++)
            if(arrays[i]!=0)
                characters.add(new Character1((char) (i), arrays[i]));
        Collections.sort(characters);
        StringBuilder result = new StringBuilder();
        int count = 0;
        for(Character1 character : characters){
            for(int j = count; j < count + character.frequency; j++)
                result.append(character.value);
            count += character.frequency;
        }
        return result.toString();
    }

    public static void main(String[] args){
        String s = "sadhfghFGYGAGKAKSHDasbdhajdjgajgDGKSAGD";
        SortCharactersByFrequency solution = new SortCharactersByFrequency();
        String result = solution.frequencySort(s);
        System.out.print(result);

    }
}

class Character1 implements Comparable{
    char value;
    int frequency = 0;

    public Character1(char value, int frequency){
        this.value = value;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Object o) {
        Character n = (Character)o;
        if(this.frequency < ((Character1) o).frequency)
            return 1;
        if(this.frequency == ((Character1) o).frequency)
            return ((Character1) o).value-this.value;
        return -1;
    }
}