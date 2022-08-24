package BinaryTree;

public class NodesInCompleteTree extends LevelwiseTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        printLevelWise(root);
        int nodes = countNodes(root);
        System.out.println(nodes);
    }

    private static int countNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        if(lh == rh) {
            int lnodes = (int) Math.pow(2, lh) - 1;
            int rnodes = (int) Math.pow(2, rh) - 1;
            return 1 + lnodes + rnodes;
        }
        int lnodes = countNodes(root.left);
        int rnodes = countNodes(root.right);
        // System.out.println(root.data + " "+  lh + ", " + rh);
        
        return 1 + lnodes + rnodes;
    }

    private static int height(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);

        return 1 + Math.max(lh, rh);
    }
}
