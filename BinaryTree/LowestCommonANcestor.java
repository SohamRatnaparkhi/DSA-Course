public class LowestCommonANcestor extends LevelwiseTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        printLevelWise(root);
        System.out.println(ancestor(root, sc.nextInt(), sc.nextInt()).data);
    }

    private static BinaryTreeNode<Integer> ancestor(BinaryTreeNode<Integer> root, int x, int y) {
        if (root == null)
            return null;
        if (root.data == x || root.data == y) {
            return root;
        }
         
        // BinaryTreeNode<Integer> lca = root;
        BinaryTreeNode<Integer> left = ancestor(root.left, x, y);
        BinaryTreeNode<Integer> right = ancestor(root.right, x, y);
        if(left != null && right != null)
            return root;
        if (left != null && right == null) {
            return left;
        } else {
            return right;
        }
        // return null;
    }
}
