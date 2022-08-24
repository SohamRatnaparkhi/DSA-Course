package BinaryTree;

public class RemoveLeafNodes extends BinaryTreeUse {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeBinaryTree(0, true, false);
        BinaryTreeNode<Integer> newRoot = removeLeaf(root);
        printTree(newRoot);
    }

    private static BinaryTreeNode<Integer> removeLeaf(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return null;
        }
        if(root.left == null && root.right == null) {
            return null;
        }
        root.left = removeLeaf(root.left);
        root.right = removeLeaf(root.right);
        
        return root;
    }
}
