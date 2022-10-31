package BinaryTree2;

public class MaxWidth extends LevelwiseTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        int width = treeWidth(root);
        System.out.println(width);
    }

    private static int treeWidth(BinaryTreeNode<Integer> root) {
        return 0;
    }
}
