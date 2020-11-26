import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/***
 * Index: 1631
 * Difficulty: Medium
 * Related Topic: Binary Search, Depth-First Search, Union Find, Graph
 */

/***
 * LC212周赛的第三道，图我是真的没学好。。
 * 解法一：Dijikstra algorithm
 * Dijkstra算法是解决带权重的有向图的单源最短路径的一种方法，要求所有权重为非负值。
 * 1. 初始化，将除起点s之外所有结点的值d记为无穷，前驱记为NULL。
 * 2. 集合S为空。(S = V - Q)
 * 3. 集合Q为G.V，即结点的集合。（Q为最小优先队列）
 * 4. 当Q不为空时
 *    4.1. 从Q中找出d最小的结点，插入S中。
 *    4.2. 对于u的所有邻接结点v，RELAX(u,v,w)
 * Dijkstra算法的时间复杂度依赖于最小队列的实现(如果以数组形式实现，找出d最小的结点需要O(V)的复杂度)，总时间约为O(ElgV)
 */

public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] dist = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                dist[i][j] = Integer.MAX_VALUE;
        dist[0][0] = 0;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        priorityQueue.add(new int[]{0,0,0}); // distance, row, col
        int[] direction = {0,1,0,-1,0};
        // while只会做rows*cols+1次，也就是每个结点只需要遍历一次
        /***
         * Q：关于为什么一个结点不会被add两次？
         * A：前提:只有当它被更新过的dist大于从另一条路到它的new_distance时（因为要找寻最小的effort），结点才会被加入队列。
         *    那这个情况可能发生吗？是不可能的。原因就在于优先队列。
         *    优先队列，只要是它处理过的结点，它到那个结点已经形成了最短路径。而在形成这个path的过程中，优先队列会加入一些
         *    周围的结点，虽然它们和这个最短路径没有关系，但因为它们就在最短路径的旁边，所以它也一定是最短路径。
         *    因此，只要是加入了优先队列，那它存的min[0]就已经是最小effort了，不可能再会有更小的了。
         */

        while(!priorityQueue.isEmpty()){
            int[] min = priorityQueue.poll();
            int distance = min[0], row = min[1], col = min[2];
            System.out.println(min[0]+ " "+ min[1]+" "+min[2]);
            for(int i = 0; i < 4; i++){
                int new_row = row + direction[i], new_col = col + direction[i+1];
                if(new_row >= 0 && new_row < rows && new_col >= 0 && new_col < cols){
                    int new_distance = Math.max(distance, Math.abs(heights[row][col] - heights[new_row][new_col]));
                    if (dist[new_row][new_col] > new_distance) {
                        dist[new_row][new_col] = new_distance;
                        priorityQueue.add(new int[]{new_distance, new_row, new_col});
                    }
                }
            }
        }
        return dist[rows-1][cols-1];
    }

    public static void main(String[] args){
        int[][] heights = {{1,2,1,1,1},{1,1,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
        PathWithMinimumEffort solution = new PathWithMinimumEffort();
        int result = solution.minimumEffortPath(heights);
        System.out.println(result);
    }
}
