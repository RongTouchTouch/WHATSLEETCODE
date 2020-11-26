/***
 * Index: 1654
 * Difficulty: Medium
 * Related Topic: Dynamic Programming, Breadth-First Search
 */

public class MinimumJumpstoReachHome {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int[] position = new int[4001+x];
        boolean[] visited = new boolean[4001+x];
        for(int num: forbidden)
            position[num] = -1;
        if(x == 0)
            return 0;
        return jump(position, a, b, x, 0, 0, 0, visited);
    }

    public int jump(int[] position, int a, int b, int x, int cur, int flag, int step, boolean[] visited){
        if (cur < 0 || cur > 4000 + x  || position[cur] == -1 || visited[cur]){
            return -1;
        }
        // flag: 1 上一次为backward; 0 上一次为forward
        if(cur == x)
            return step;
        if(flag == 1){
            return  jump(position, a, b, x, cur+a, 0, step+1,visited);
        }
        else{
            visited[cur] = true;
            int result1 = jump(position, a, b, x, cur+a, 0, step+1,visited);
            int result2 = jump(position, a, b, x, cur-b, 1, step+1,visited);
            if (result1>=0 && result2>=0)
                return Math.min(result1, result2);
            else
                return Math.max(result1, result2);
        }
    }

    public static void main(String[] args){
        int[] forbidden = {162,118,178,152,167,100,40,74,199,186,26,73,200,127,30,124,193,84,184,36,103,149,153,9,54,
                154,133,95,45,198,79,157,64,122,59,71,48,177,82,35,14,176,16,108,111,6,168,31,134,164,136,72,98};
        int a = 29;
        int b = 98;
        int x = 80;
        MinimumJumpstoReachHome solution = new MinimumJumpstoReachHome();
        int result = solution.minimumJumps(forbidden, a, b, x);
        System.out.println(result);
    }
}
