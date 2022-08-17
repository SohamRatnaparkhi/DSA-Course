public class NodesAtDepthK extends BinaryTreeUse {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeBinaryTree(0, true, false);
        printNodeAtDepthK(root, 3);
    }

    private static void printNodeAtDepthK(BinaryTreeNode<Integer> root, int k) {
        if (root == null) {
            return;
        }
        if(k == 0) {
            System.out.println(root.data);
        }
        printNodeAtDepthK(root.left, k-1);
        printNodeAtDepthK(root.right, k-1);
    }
}
