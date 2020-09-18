import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }

/***
 * Follow up:Recursive solution is trivial, could you do it iteratively?
 * 解法一：栈（正确）
 * 虽然想出使用栈并不困难，但是具体怎么实现还是没想出来。看了解析感觉关键点在于while中的迭代变量应该选哪个。
 * 1. 首先需要一个栈treeNodes，里面存上待处理的树结点。
 * 2. 变量temp，注意这个temp不应该是每次循环都要重新取，而是要使用上一轮循环更新过的temp！
 *    （原先我想的是每次都TreeNode temp = treeNodes.peek();这样是无法遍历整棵树的）
 * 3. temp，temp首先得往左走到底，每次走都要push，然后temp=temp.left，走到底后，输出，然后出栈。此时栈顶刚好是最左节点的
 *    父节点，于是开始考虑temp=temp.right。值得注意的是，每次左子树要用while走到底，但右子树只需要if走一次。
 */

//public class BinaryTreeInorderTraversal {
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        Stack<TreeNode> treeNodes = new Stack<>();
//        TreeNode temp = root;
//        while(!treeNodes.isEmpty()|| temp != null){
//            while (temp!= null){
//                treeNodes.push(temp);
//                temp = temp.left;
//            }
//            temp = treeNodes.pop();
//            result.add(temp.val);
//            temp = temp.right;
//        }
//        return result;
//    }
//
//    public static void main(String[] argv){
//        TreeNode root = new TreeNode(1);
//        TreeNode son1 = new TreeNode(2);
//        root.left = son1;
//        TreeNode son2 = new TreeNode(3);
//        root.right = son2;
//        TreeNode son3 = new TreeNode(4);
//        son1.right = son3;
//        TreeNode son4 = new TreeNode(5);
//        son3.left = son4;
//        TreeNode son5 = new TreeNode(6);
//        son3.right = son5;;
//
//        BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();
//        List<Integer> result = solution.inorderTraversal(root);
//        System.out.println(result);
//    }
//}


/***
 * 解法二：Morris Traversal（正确）
 * 太牛逼了!!!!!!
 * 总的思路是想办法遍历完左边的子节点后，可以回到原来的根节点。于是让叶节点的右孩子指向根节点，就可以达到这个目的。
 * 优势是它只需要O(1)的存储空间，但这个思路真的是太nb了!
 *
 * （直接抄了解析）记当前遍历的节点为 cur。
 * 1. cur.left 为 null，保存 cur 的值，更新 cur = cur.right
 * 2. cur.left 不为 null，找到 cur.left 这颗子树最右边的节点记做 last
 *  2.1 last.right 为 null，那么将 last.right = cur，更新 cur = cur.left
 *  2.2 last.right 不为 null，说明之前已经访问过，第二次来到这里，表明当前子树遍历完成，保存 cur 的值，
 *      更新 cur = cur.right
 *
 * 顺便，这道题的代码挺难写的555  要注意在哪里更新cur
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        TreeNode last;
        while(cur != null){
            if (cur.left == null){
                result.add(cur.val);
                cur = cur.right;
            }
            else {
                last = cur.left;
                while(last.right != null && last.right != cur)
                    last = last.right;
                if(last.right == null){
                    last.right = cur;
                    cur = cur.left;
                }
                if (last.right == cur){
                    last.right = null;
                    result.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return result;
    }

    public static void main(String[] argv){
        TreeNode root = new TreeNode(1);
        TreeNode son1 = new TreeNode(2);
        root.left = son1;
        TreeNode son2 = new TreeNode(3);
        root.right = son2;
        TreeNode son3 = new TreeNode(4);
        son1.right = son3;
        TreeNode son4 = new TreeNode(5);
        son3.left = son4;
        TreeNode son5 = new TreeNode(6);
        son3.right = son5;;

        BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();
        List<Integer> result = solution.inorderTraversal(root);
        System.out.println(result);
    }
}
