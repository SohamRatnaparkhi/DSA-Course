package BinaryTree;

/**
 * CheckBalanceTree
 */
public class CheckBalanceTree extends BinaryTreeUse{
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeBinaryTree(0, true, false);
        printTree(root);
        System.out.println(isBalanced(root));
        // System.out.println(isBalancedBetter(root));
    }

    // private static boolean isBalancedBetter(BinaryTreeNode<Integer> root) {
        
    // }

    private static boolean isBalanced(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return true;
        }
        int leftHeight = treeHeight(root.left); 
        int rightHeight = treeHeight(root.right);
        
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return leftHeight == rightHeight == true;
    }

    private static int treeHeight(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}