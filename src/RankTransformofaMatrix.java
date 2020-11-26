import javafx.util.Pair;

import java.util.*;

/***
 * Index: 1632
 * Difficulty: Hard
 * Related Topic: Greedy, Union Find
 */

/***
 * Intuition
 * dict[a] records all element index [i,j] with A[i][j] = a
 * Since he rank should be as small as possible,
 * we want to assign small rank first.
 * As a result, we iterate all elements from small value to big.
 *
 * Explanation
 * We apply union find by row and col,
 * (my this method is detailed explained in 947. Most Stones Removed with Same Row or Column)
 * find the maximum rank of elements sharing the same row or col.
 * Then we update the the rank.
 */

class UnionFind2 {

    private final int[] parent;

    public UnionFind2(int n){
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int n){
        while (n != parent[n]){
            n = parent[n];
        }
        return n;
    }

    public Pair<Integer, Integer> union(int p, int q){
        int i = find(p);
        int j = find(q);
        parent[i] = j;
        return new Pair<>(i, j);
    }
}

public class RankTransformofaMatrix {
    public int[][] matrixRankTransform(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        HashMap<Integer, List<Pair<Integer, Integer>>> hashMap = new HashMap<>();
        for( int i = 0; i < rows; i++ ) {
            for( int j = 0; j < cols; j++) {
                // 写法注意
                hashMap.computeIfAbsent(matrix[i][j], l -> new ArrayList<>()).add(new Pair<>(i, j));
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>(hashMap.keySet());
        Collections.sort(arrayList);
        int[] rank = new int[rows+cols];
        for( Integer key : arrayList ){
            int[] rank2 = rank.clone();
            UnionFind2 unionFind2 = new UnionFind2(rows+cols);
            for(Pair<Integer, Integer> pair : hashMap.get(key)){
                int row = pair.getKey();
                int col = pair.getValue();
                Pair<Integer, Integer> parent = unionFind2.union(row, col + rows);
                rank2[parent.getValue()] = Math.max(rank2[parent.getKey()], rank2[parent.getValue()]);
            }
            for(Pair<Integer, Integer> pair : hashMap.get(key)){
                int row = pair.getKey();
                int col = pair.getValue();
                rank[row] = rank[col + rows] = matrix[row][col] = rank2[unionFind2.find(pair.getKey())] + 1;
            }
        }
        return matrix;
    }

    public static void main(String[] args){
        int[][] matrix = {{-37,-50,-3,44},{-37,46,13,-32},{47,-42,-3,-40},{-17,-22,-39,24}};
        RankTransformofaMatrix solution = new RankTransformofaMatrix();
        int[][] result = solution.matrixRankTransform(matrix);
        for( int i = 0; i < matrix.length; i++ ) {
            for( int j = 0; j < matrix[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}



//    public int[][] matrixRankTransform(int[][] matrix) {
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//        int[] rank = new int[rows + cols];
//        // invMap：key = 真实值; value = (row, col)
//        Map<Integer, List<Pair<Integer, Integer>>> invMap = new HashMap<>();
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                invMap.computeIfAbsent(matrix[i][j], l -> new ArrayList<>()).add(new Pair<>(i, j));
//            }
//        }
//        // keySet：真实值的set
//        List<Integer> keySet = new ArrayList<>(invMap.keySet());
//        Collections.sort(keySet);
//        for (int key : keySet) {
//            // uf 最多只需要rows + cols个值
//            UnionFind2 uf = new UnionFind2(rows + cols);
//            int[] rank2 = rank.clone();
//            // coord代表真实数字相同的pair
//            for (Pair<Integer, Integer> coord : invMap.get(key)) {
//                // 因为只有rows + cols个值， 所以相当于0~rows-1是用来记rows， rows~rows+cols-1用来记
//                Pair<Integer, Integer> res = uf.union(coord.getKey(), coord.getValue() + rows);
//                rank2[res.getValue()] = Math.max(rank2[res.getValue()], rank2[res.getKey()]);
//            }
//            for (Pair<Integer, Integer> coord : invMap.get(key)) {
//                rank[coord.getKey()] = rank[coord.getValue() + rows] = matrix[coord.getKey()][coord.getValue()] = rank2[uf.find(coord.getKey())] + 1;
//            }
//        }
//        return matrix;