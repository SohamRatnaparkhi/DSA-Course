public class MirrorTree extends BinaryTreeUse {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeBinaryTree(0, true, false);
        printTree(root);
        mirrorTree(root);
        System.out.println("---------------");
        printTree(root);
    }

    private static void mirrorTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        
        BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorTree(root.left);
        mirrorTree(root.right);
    }
}
