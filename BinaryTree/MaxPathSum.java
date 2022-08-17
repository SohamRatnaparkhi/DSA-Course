public class MaxPathSum extends LevelwiseTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        printLevelWise(root);
        maxSumPath(root);
        System.out.println(mxsum);
    }

    static int mxsum = Integer.MIN_VALUE;

    private static int maxSumPath(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int ls = maxSumPath(root.left);
        int rs = maxSumPath(root.right);
        mxsum = Math.max(mxsum, ls + rs + root.data);
        // System.out.println(mxsum);
        int val = root.data >= 0 ? root.data : 0;

        return val + Math.max(rs, ls);
    }
}
