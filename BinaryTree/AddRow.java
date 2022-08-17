public class AddRow extends LevelwiseTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        printLevelWise(root);
        System.out.println("Value and depth");
        addOneRow(root, sc.nextInt(), sc.nextInt());
        printLevelWise(root);
    }
    public static BinaryTreeNode<Integer> addOneRow(BinaryTreeNode<Integer> root, int val, int depth) {
        if (root == null) {
            return null;
        }
        if (depth == 2) {
            BinaryTreeNode<Integer> tempLeft = root.left;
            BinaryTreeNode<Integer> tempRight = root.right;
            BinaryTreeNode<Integer> newNodel = new BinaryTreeNode<Integer>(val);
            BinaryTreeNode<Integer> newNoder = new BinaryTreeNode<Integer>(val);
            if (true) {
                root.left = newNodel;
                newNodel.left = tempLeft;
            }
            if (true) {
                root.right = newNoder;
                newNoder.right = tempRight;
            }
            // return root;
        }
        addOneRow(root.left, val, depth - 1);
        addOneRow(root.right, val, depth - 1);

        return root;
    }
}
