package BinaryTree;

public class FlattenTree extends LevelwiseTree{
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        printTree(root);
        flattenTree(root);
        printTree(root);
    }
    static BinaryTreeNode<Integer> prev = null;
    private static void flattenTree(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        
            flattenTree(root.right);
            flattenTree(root.left);

            // if(root.left == null || root.right == null)
            //     return;

            // BinaryTreeNode<Integer> temp = root.right;

            root.right = prev;
            root.left = null;
            prev = root;
        
    }
}
