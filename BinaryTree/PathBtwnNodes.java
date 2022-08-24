package BinaryTree;

import java.util.ArrayList;


public class PathBtwnNodes extends LevelwiseTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        printLevelWise(root);
        ArrayList<Integer> ans = new ArrayList<>();
        pathBtwnNodes(ans, sc.nextInt(), sc.nextInt(), root);
        System.out.println(ans);
    }

    private static boolean pathBtwnNodes(ArrayList<Integer> ans, int nodeA, int nodeB, BinaryTreeNode<Integer> root) {
        if (root == null)
            return false;

        ans.add(root.data);
        if (root.data == nodeA || root.data == nodeB) {
            return true;
        }

        boolean left = pathBtwnNodes(ans, nodeA, nodeB, root.left);
        boolean right = pathBtwnNodes(ans, nodeA, nodeB, root.right);

        if (left || right) {
            return true;
        }
        ans.remove(ans.size() - 1);

        return false;
        
    }
}
