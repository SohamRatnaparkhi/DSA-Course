// package BinaryTree;

public class TreeHeight extends BinaryTreeUse {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeBinaryTree(0, true, false);
        int height = treeHeight(root);
        System.out.println(height);
    }

    private static int treeHeight(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
