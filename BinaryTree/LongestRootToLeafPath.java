package BinaryTree;

import java.util.ArrayList;

public class LongestRootToLeafPath extends LevelwiseTree{
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        System.out.println(longestPath(root));        
    }

    private static ArrayList<Integer> longestPath(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> left = longestPath(root.left);
        ArrayList<Integer> right = longestPath(root.right);

        if (left.size() >= right.size()) {
            left.add(root.data);
            return left;
        } else {
            right.add(root.data);
            return right;
        }
    }
}
