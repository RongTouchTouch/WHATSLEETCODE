/***
 * Index: 134
 * Difficulty: Medium
 * Related Topic: Greedy
 */

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length < 1 || cost.length < 1)
            return -1;
        int sum = 0, index = -1, rest = 0;
        for(int i = 0; i < gas.length; i++){
            sum += gas[i] - cost[i];
            if(index == -1 && sum >= 0){
                index = i;
            }
            else if(sum < 0){
                index = -1;
                rest += sum;
                sum = 0;
            }
        }
        if( sum + rest < 0)
            return -1;
        return index;
    }

    public static void main(String[] args){
        int[] gas = {3,0,0,0,3,3,3};
        int[] cost ={2,2,2,2,1,1,1};
        GasStation solution = new GasStation();
        int result = solution.canCompleteCircuit(gas, cost);
        System.out.println(result);
    }
}
