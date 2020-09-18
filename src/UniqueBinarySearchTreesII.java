import java.util.ArrayList;
import java.util.List;

/***
 * 解法一：递归
 * Medium日常做不出来
 * 原来比较纠结的一个问题是如何让数字累加，因为我做UniqueBinarySearchTree的时候偷懒用的公式法，但它这边比较巧妙的用了
 * start和end，然后每次add的时候value就有办法取了。
 *
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if (n == 0) {
            return ans;
        }
        return getAns(1, n);
    }

    private List<TreeNode> getAns(int start, int end) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        //写代码的时候注意这里不是直接return null 笨死了
        if( start > end ){
            ans.add(null);
            return ans;
        }
        if( start == end ){
            TreeNode newroot = new TreeNode(start);
            ans.add(newroot);
            return ans;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> left = getAns(start, i-1);
            List<TreeNode> right = getAns(i+1, end);
            for( TreeNode leftnode : left)
                for ( TreeNode rightnode : right) {
                    TreeNode newroot = new TreeNode(i);
                    ans.add(newroot);
                    newroot.left = leftnode;
                    newroot.right = rightnode;
                }
        }
        return ans;
    }
    public static void main(String[] argv){
        UniqueBinarySearchTreesII solution = new UniqueBinarySearchTreesII();
        List<TreeNode> result = solution.generateTrees(8);
        System.out.println(result);
    }
}
