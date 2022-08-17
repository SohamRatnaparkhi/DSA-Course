// package BinaryTree;

public class TreeSum extends BinaryTreeUse {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeBinaryTree(0, true, false);
        int length = treeSum(root, 0);
        printTree(root);
        System.out.println(length);
    }

    private static int treeSum(BinaryTreeNode<Integer> root, int sum) {
        if (root == null) {
            return 0;
        }
         
        int leftTreeSum = treeSum(root.left, sum);
        int rightTreeSum = treeSum(root.right, sum);

        return root.data + leftTreeSum + rightTreeSum;
    }
}
