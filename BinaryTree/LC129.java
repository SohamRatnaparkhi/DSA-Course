package BinaryTree;

public class LC129 extends LevelwiseTree {
    static int s;
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        s = sumOfPath(root, "");
        System.out.println(s);
    }

    private static int sumOfPath(BinaryTreeNode<Integer> root, String path) {
        if (root == null) {
            return 0;
        }
        path += root.data;
        if (isLeaf(root)) {
            // System.out.println(path);
            // System.out.println(Integer.parseInt(path));
            
            s += Integer.parseInt(path);
            path = "";
        }
        sumOfPath(root.left, path);
        sumOfPath(root.right, path);

        return s;
    }

    private static boolean isLeaf(BinaryTreeNode<Integer> root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }
}
