// package BinaryTree;

public class GreaterThan extends BinaryTreeUse {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeBinaryTree(0, true, false);
        int greatestNode = greatestNode(root);
        int nodesGreaterThanX = greaterThanX(root, 4);
        System.out.println(greatestNode);
        System.out.println(nodesGreaterThanX);
    }

    static int n = 0;

    private static int greaterThanX(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return -1;
        }
        if (root.data > x) {
            n += 1;
        }
        greaterThanX(root.left, x);
        greaterThanX(root.right, x);

        return n;
    }

    private static int greatestNode(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return -1;
        }

        int leftMax = greatestNode(root.left);
        int rightMax = greatestNode(root.right);

        return Math.max(root.data, Math.max(leftMax, rightMax));
    }
}
