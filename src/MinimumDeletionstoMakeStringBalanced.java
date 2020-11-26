/***
 * Index: 1653
 * Difficulty: Medium
 * Related Topic: String, Greedy
 */

public class MinimumDeletionstoMakeStringBalanced {
    public int minimumDeletions(String s) {
        int[] nums_a = new int[s.length()];
        int[] min = new int[s.length()];
        for(int i = 0; i < s.length() ; i++)
            recursion(s, nums_a, min, i);
        return min[s.length()-1];
    }

    //把第一段if放在外面可以节约更多时间
    public void recursion(String s, int[] nums_a, int[] min, int index){
        if(index == 0){
            min[index] = 0;
            if(s.charAt(index) == 'a')
                nums_a[index]++;
        }
        else{
            if (s.charAt(index) == 'b') {
                min[index] = min[index - 1];
                nums_a[index] = nums_a[index-1];
            }
            else{
                min[index] = Math.min(index - nums_a[index-1], min[index-1] +1);
                nums_a[index] = nums_a[index-1]+1;
            }
        }
    }

    public static void main(String[] args){
        String s = "baabaabaab";
        MinimumDeletionstoMakeStringBalanced solution = new MinimumDeletionstoMakeStringBalanced();
        int result = solution.minimumDeletions(s);
        System.out.println(result);
    }
}
