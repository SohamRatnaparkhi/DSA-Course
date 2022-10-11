package BinaryTree;

/**
 * CheckBalanceTree
 */
public class CheckBalanceTree extends BinaryTreeUse{
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeBinaryTree(0, true, false);
        printTree(root);
        System.out.println(isBalanced(root));
        System.out.println(isBalancedBetter(root));
    }

    private static int isBalancedBetter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int left = isBalancedBetter(root.left);
        int right = isBalancedBetter(root.right);

        if(left == -1 || right == -1) {
            return -1;
        }

        if(Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

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