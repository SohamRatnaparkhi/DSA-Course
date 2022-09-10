package GenericTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SimilarTree extends GenericTree {
    public static void main(String[] args) {
        TreeNode<Integer> root1 = makeTree();
        TreeNode<Integer> root2 = makeTree();
        System.out.println(checkSimilarity(root1, root2));
    }

    private static boolean checkSimilarity(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if((root1 == null && root2!= null) || (root2 == null && root1 != null))
            return false;
        Queue<TreeNode<Integer>> q1 = new LinkedList<>();
        Queue<TreeNode<Integer>> q2 = new LinkedList<>();
        q1.add(root1);
        q2.add(root2);

        while(!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode<Integer> front1 = q1.poll();
            TreeNode<Integer> front2 = q2.poll();

            if (front1.data != front2.data)
                return false;
            ArrayList<TreeNode<Integer>> children1 = front1.children;
            ArrayList<TreeNode<Integer>> children2 = front2.children;

            for (TreeNode<Integer> treeNode : children1) {
                q1.add(treeNode);
            }

            for (TreeNode<Integer> treeNode : children2) {
                q2.add(treeNode);
            }

        }
        if((!q1.isEmpty() && q2.isEmpty()) || (!q2.isEmpty() && q1.isEmpty())) {
            return false;
        }
        return true;        
    }
}
