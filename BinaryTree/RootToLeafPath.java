import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * RootToLeafPath
 */
public class RootToLeafPath extends LevelwiseTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        printLevelWise(root);
        List<String> ans = rootToLeafPath(root, "", new ArrayList<>());
        System.out.println(ans);
        Stack<Integer> lp = longestRootToLeafPath(root);
        System.out.println(lp);

    }

    private static List<String> rootToLeafPath(BinaryTreeNode<Integer> root, String path, ArrayList<String> ans) {
        if (root == null) {
            return ans;
        }
        if (isLeaf(root)) {
            path += root.data;
            ans.add(path);
            path = "";
        }
        path += root.data + "->";
        rootToLeafPath(root.left, path, ans);
        rootToLeafPath(root.right, path, ans);

        return ans;
    }

    private static Stack<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new Stack<>();
        }
        Stack<Integer> left = longestRootToLeafPath(root.left);
        Stack<Integer> right = longestRootToLeafPath(root.right);

        if (left.size() >= right.size()) {
            left.push(root.data);
            return left;
        } else {
            right.push(root.data);
            return right;
        }
    }

    private static boolean isLeaf(BinaryTreeNode<Integer> root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }
}