package GenericTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RemoveLeaf extends GenericTree {
    public static void main(String[] args) {
        TreeNode<Integer> root = makeTree();
        TreeNode<Integer> newRoot = removeLeaves(root);
        printTree(newRoot);
    }

    private static TreeNode<Integer> removeLeaves(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        // System.out.println(root.data);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> front = q.poll();
                ArrayList<TreeNode<Integer>> children = front.children;
                for (TreeNode<Integer> child : children) {
                    if (child.children.size() == 0) {
                        // front = null;
                        children.remove(child);
                    }
                    // System.out.print(child.data + " ");
                    q.add(child);
                }
            }
        }
        return root;
    }
}
