package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversal extends LevelwiseTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>();
        printZigZag(root);
    }

    private static void printZigZag(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            // int size = q.size();
        }
    }
}
