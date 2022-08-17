public class NoOfLeaf extends BinaryTreeUse {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeBinaryTree(0, true, false);
        int NoOfLeaf = countLeaf(root);
        System.out.println(NoOfLeaf);
    }

    private static int countLeaf(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            return 1;
        }
        int leftLeaf = countLeaf(root.left);
        int rightLeaf = countLeaf(root.right);
        
        return leftLeaf + rightLeaf;
    }
}
