import java.rmi.MarshalException;

public class CheckSibling extends LevelwiseTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        printLevelWise(root);
        System.out.println("Enter siblings to check");
        boolean ans = checkSibling(root, sc.nextInt(), sc.nextInt());
        System.out.println(ans);
    }

    private static boolean checkSibling(BinaryTreeNode<Integer> root, int left, int right) {
        if (root == null) {
            return false;
        }

        if(root.left == null || root.right == null) {
            return false;
        }

        if (root.left.data == left && root.right.data == right) {
            return true;
        }

        boolean leftResult = checkSibling(root.left, left, right);
        if (leftResult) {
            return true;
        }
        boolean rightResult = checkSibling(root.right, left, right);
        return rightResult;
    }
}
