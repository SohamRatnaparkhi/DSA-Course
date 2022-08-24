package BinaryTree;

public class BInaryTreeLength extends BinaryTreeUse {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeBinaryTree(0, true, false);
        int length = treeLength(root);
        System.out.println(length);
    }

    private static int treeLength(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
         
        int leftTreeLength = treeLength(root.left);
        int rightTreeLength = treeLength(root.right);

        return 1 + leftTreeLength + rightTreeLength;
    }
}
