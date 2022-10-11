package BinaryTree2;

public class MaxOathSum extends LevelwiseTree{
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        int[] mxsum = new int[1];
        pathSum(root, mxsum);
        System.out.println(mxsum[0]);
    }

    private static int pathSum(BinaryTreeNode<Integer> root, int[] mxsum) {
        if (root == null) {
            return 0;
        }

        int rs = Math.max(0, pathSum(root.right, mxsum));
        int ls = Math.max(0, pathSum(root.left, mxsum));
        mxsum[0] = Math.max(rs + root.data + ls, mxsum[0]); 

        return Math.max(rs, ls) + root.data;
    }
}
