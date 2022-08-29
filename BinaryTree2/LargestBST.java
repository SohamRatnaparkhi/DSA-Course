package BinaryTree2;

public class LargestBST extends LevelwiseTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        printTree(root);
        printLevelWise(root);
        System.out.println("------------");
        largestBST(root);
        System.out.println(mh);
    }

    static int mh = 0, smh = 0;

    private static int largestBST(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;
        int lh = largestBST(root.left);
        int rh = largestBST(root.right);
        int x = Math.max(lh, rh);
        if (x > mh) {
            smh = mh;
            mh = x;
        }
        return 1 + x;
    }
}
