/***
 * Index: 947
 * Difficulty: Medium
 * Related Topic: Depth-First Search, Union Find
 */

import java.util.*;

/***
 * 解法一：查并集
 * （对查并集还不太熟悉，而且今天又感冒了，是在脑子转不起来，只能先抄个答案）
 * 整体思路：先把所有共享行列的点，看作是一个点，于是可以得到很多的孤立点，石头总数-孤立点=最多能移走的石头数。
 *          于是问题变成了找出孤立点的数目。
 * 首先，由于石头的坐标是不连续的，故不能使用数组，只能使用HashMap做，但做法适合HashMap一样的。
 * 行和列要分开来考虑。对于数组可以使用col+Constant区分row和col，这里可以使用union(x, ~y)，~y=-y-1
 * 对于行和列，都要返回它们最顶上的parent，如果不存在则put一个。
 *
 * 要想清楚的一个问题是，行和列是如何建立联系的？
 * 比如(0,0)这个坐标，首先会被存成<0,0>和<~0,~0>，union就是把横坐标和纵坐标建立关系，让它变成<0,~0>和<~0,~0>。（准确来说是
 * put了<0,~0>替换了原来的<0,0>）如此一来，对于后来的坐标比如(0,1)，由于0已经作为key出现了，所以它只需要put<~1,~1>，再经过
 * union操作新put进<~0,~1>，新的联系就建立好了。（注意union的时候用的都是parent结点）
 */

//class UnionFind1 {
//
//    public final HashMap<Integer, Integer> parent;
//    public int count;
//
//    public UnionFind1(){
//        parent = new HashMap<>();
//        count = 0;
//    }
//
//    public int find(int n){
//        if(parent.putIfAbsent(n, n) == null){
//            count++;
//        }
//
//        while (parent.get(n)!=n){
//            n = parent.get(n);
//        }
//        return n;
//    }
//
//    public void union(int p, int q){
//        int i = find(p);
//        int j = find(q);
//        if(i != j) {
//            parent.put(i,j);
//            count--;
//        }
//    }
//}
//
//public class MostStonesRemovedwithSameRoworColumn {
//    public int removeStones(int[][] stones) {
//        UnionFind1 unionFind = new UnionFind1();
//        for(int[] pair : stones){
//            unionFind.union(pair[0], ~pair[1]);
//        }
//        return stones.length-unionFind.count;
//    }
//
//    public static void main(String[] args){
//        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
//        MostStonesRemovedwithSameRoworColumn solution = new MostStonesRemovedwithSameRoworColumn();
//        int result = solution.removeStones(stones);
//        System.out.println(result);
//    }
//}

/***
 * 解法二：DFS
 * 和UnionFind差不多的思路，是不是可以用Union Find做的题都可以用DFS做？
 * 而且DFS普遍比UnionFind快（可以想象
 */
class MostStonesRemovedwithSameRoworColumn {
    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] stone : stones) {
            graph.computeIfAbsent(stone[0], k -> new ArrayList<>()).add(~stone[1]);
            graph.computeIfAbsent(~stone[1], k -> new ArrayList<>()).add(stone[0]);
        }
        int numOfComponent = 0;
        Set<Integer> visited = new HashSet<>();
        for (int[] stone : stones) {
            for (int i = 0; i < 2; i++) {
                int s = i == 0 ? stone[0] : ~stone[1];
                if (!visited.contains(s)) {
                    numOfComponent++;
                    dfs(s, graph, visited);
                }
            }
        }
        return stones.length - numOfComponent;
    }

    private void dfs(int stone, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if (visited.add(stone)) {
            for (int next : graph.get(stone)) {
                dfs(next, graph, visited);
            }
        }
    }

    public static void main(String[] args){
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        MostStonesRemovedwithSameRoworColumn solution = new MostStonesRemovedwithSameRoworColumn();
        int result = solution.removeStones(stones);
        System.out.println(result);
    }
}