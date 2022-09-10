package GenericTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CountLeaf extends GenericTree {
    public static void main(String[] args) {
        TreeNode<Integer> root = makeTree();
        printTreeLevelWise(root);
        int ans = countLeaves(root);
        System.out.println(ans);
    }

    private static int countLeaves(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        int leaf = 0;
        // System.out.println(root.data);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> front = q.poll();
                ArrayList<TreeNode<Integer>> children = front.children;
                if (children.size() == 0) {
                    leaf++;
                }
                for (TreeNode<Integer> child : children) {
                    // System.out.print(child.data + " ");
                    q.add(child);
                }
            }
        }
        return leaf;
    }
}
