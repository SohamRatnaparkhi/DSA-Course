package BinaryTree2;

public class CheckBst extends LevelwiseTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        printTree(root);
        boolean ans = isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(ans);
    }

    private static boolean isBst(BinaryTreeNode<Integer> root, int minValue, int maxValue) {
        if (root == null)
            return true;

        if (root.data < minValue) {
            return false;
        }
        boolean left = isBst(root.left, minValue, root.data);

        if (root.data > maxValue) {
            return false;
        }
        boolean right = isBst(root.right, root.data, maxValue);

        return right && left;

    }
}