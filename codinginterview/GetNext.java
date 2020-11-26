public class GetNext {
    public BinaryTreeNode getNext(BinaryTreeNode root, BinaryTreeNode node) {
        if (root == null || node == null)
            return null;
        BinaryTreeNode temp = null;
        if (node.right != null) {
            temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
        }
        // 我本来写的else if(node == node.parent.left)，但这样不能保证node有parent 所以改一下
        else if (node.parent != null) {
            temp = node;
            BinaryTreeNode parent = node.parent;
            while (parent.parent != null && node == parent.right) {
                node = node.parent;
                node.parent = parent.parent;
            }
        }
        return temp;
    }
}
