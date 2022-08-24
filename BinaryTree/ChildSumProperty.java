package BinaryTree;

public class ChildSumProperty extends LevelwiseTree{
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        printLevelWise(root);
        BinaryTreeNode<Integer> newRoot = childSum(root);
        printLevelWise(newRoot);
    }

    private static BinaryTreeNode<Integer> childSum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        if (root.left == null || root.right == null) {
            return root;
        }
        if (root.left.data + root.right.data < root.data) {
            root.left.data = root.right.data = root.data;
        } else {
            root.data = root.left.data + root.right.data;
        }
        BinaryTreeNode<Integer> left = childSum(root.left);
        BinaryTreeNode<Integer> right = childSum(root.right);
        root.data = left.data + right.data;
        return root;
    }
}
