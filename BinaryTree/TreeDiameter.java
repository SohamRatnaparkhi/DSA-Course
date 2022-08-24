package BinaryTree;

public class TreeDiameter extends BinaryTreeUse{
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeBinaryTree(0, true, false);
        int diameter = treeDiameter(root);
        System.out.println(diameter);        
    }
    private static int treeDiameter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int rootD = treeHeight(root.left) + treeHeight(root.right);
        int leftD = treeDiameter(root.left);
        int rightD = treeDiameter(root.right);

        return Math.max(rootD, Math.max(leftD, rightD));
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
