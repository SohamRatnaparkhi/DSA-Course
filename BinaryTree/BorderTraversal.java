import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BorderTraversal extends LevelwiseTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        printLevelWise(root);
        borderTraveresal(root);
    }

    private static void borderTraveresal(BinaryTreeNode<Integer> root) {
        /*
         * 3 steps
         * for left traversal - go left; if left null then right; stop when leaf nodes
         * for right traversal - go right; same as left for right but sdd to stack first
         * preorder traversal + leaf nodes for ends
         */
        Queue<Integer> ans = new LinkedList<>();
        ans.add(root.data);
        addLeft(root, ans);
        System.out.println(ans);
        addLeaf(root, ans);
        System.out.println(ans);
        addRight(root, ans);
        System.out.println(ans);
    }

    private static void addLeaf(BinaryTreeNode<Integer> root, Queue<Integer> ans) {
        if (root == null) {
            return;
        }
        if (isLeaf(root)) {
            ans.add(root.data);
            return;
        }
        if(root.left != null)
            addLeaf(root.left, ans);
        if(root.right != null)
            addRight(root.right, ans);
    }

    private static void addRight(BinaryTreeNode<Integer> root, Queue<Integer> ans) {
        BinaryTreeNode<Integer> curr = root.right;
        Stack<Integer> temp = new Stack<>();
        while (!isLeaf(curr) && curr != null) {
            temp.push(curr.data);
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        while (!temp.isEmpty()) {
            ans.add(temp.pop());
        }
    }

    private static void addLeft(BinaryTreeNode<Integer> root, Queue<Integer> ans) {
        BinaryTreeNode<Integer> curr = root.left;
        while (!isLeaf(curr) && curr != null) {
            ans.add(curr.data);
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private static boolean isLeaf(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }
}
