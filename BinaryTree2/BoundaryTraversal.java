package BinaryTree2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BoundaryTraversal extends LevelwiseTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        Queue<Integer> q = new LinkedList<>();
        q.add(root.data);
        addLeft(root, q);
        addLeaf(root, q);
        addRight(root, q);
        System.out.println(q);
    }

    private static void addRight(BinaryTreeNode<Integer> root, Queue<Integer> q) {
        BinaryTreeNode<Integer> curr = root.right;
        Stack<Integer> s = new Stack<>();
        while (!isLeaf(curr) && curr != null) {
            s.push(curr.data);
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    private static void addLeaf(BinaryTreeNode<Integer> root, Queue<Integer> q) {
        if (root == null) {
            return;
        }
        if (isLeaf(root)) {
            q.add(root.data);
            return;
        }
        addLeaf(root.left, q);
        addLeaf(root.right, q);
    }

    private static void addLeft(BinaryTreeNode<Integer> root, Queue<Integer> q) {
        BinaryTreeNode<Integer> curr = root.left;
        while (!isLeaf(curr) && curr != null) {
            q.add(curr.data);
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private static boolean isLeaf(BinaryTreeNode<Integer> curr) {
        return (curr.left == null) && (curr.right == null);
    }
}
