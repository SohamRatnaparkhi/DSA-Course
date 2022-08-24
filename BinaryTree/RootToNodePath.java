package BinaryTree;

import java.util.ArrayList;

public class RootToNodePath extends LevelwiseTree{
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        printLevelWise(root);
        ArrayList<Integer> ans = new ArrayList<>();
        System.out.println("Enter node");
        nodePath(root, sc.nextInt(), ans);
        System.out.println(ans);
    }

    private static boolean nodePath(BinaryTreeNode<Integer> root, int data, ArrayList<Integer> ans) {
        if (root == null) {
            return false;
        }
        ans.add(root.data);
        if (data == root.data) {
            return true;
        }
        if (nodePath(root.left, data, ans) || nodePath(root.right, data, ans)) {
            return true;
        } else {
            ans.remove(ans.size() - 1);
            return false;
        }
    }
}
