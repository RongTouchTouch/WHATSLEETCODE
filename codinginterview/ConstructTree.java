import java.util.Arrays;

class BinaryTreeNode{
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public BinaryTreeNode parent;

    BinaryTreeNode(int value){
        this.value = value;
        left = null;
        right = null;
        parent = null;
    }
}

public class ConstructTree {
    public BinaryTreeNode construct(int[] preorder, int[] endorder){
        if(preorder.length < 1)
            return null;
        BinaryTreeNode root = new BinaryTreeNode(preorder[0]);
        int index;
        for (index = 0;;index++)
        {
            if (endorder[index] == preorder[0])
                break;
        }
        root.left = construct(Arrays.copyOfRange(preorder, 1, index+1), Arrays.copyOfRange(endorder, 0, index));
        root.right = construct(Arrays.copyOfRange(preorder, index+1, preorder.length), Arrays.copyOfRange(endorder, index+1, endorder.length));
        return root;
    }

    public void print_endorder(BinaryTreeNode root){
        if(root == null)
            return;
        print_endorder(root.left);
        System.out.println(root.value);
        print_endorder(root.right);
    }

    public static void main (String[] args){
        int[] preorder = {1,2,4,7,3,5,6,8};
        int[] endorder = {4,7,2,1,5,3,8,6};
        ConstructTree solution = new ConstructTree();
        BinaryTreeNode root = solution.construct(preorder, endorder);
        solution.print_endorder(root);
    }

}
