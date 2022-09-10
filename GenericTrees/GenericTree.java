package GenericTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenericTree {
    public static void main(String[] args) {
        TreeNode<Integer> root = makeTree();
        printTree(root);
        System.out.println("Levelwise print");
        printTreeLevelWise(root);
        System.out.println("Post-order");
        postOrderTraversal(root);
    }

    private static void postOrderTraversal(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        ArrayList<TreeNode<Integer>> children = root.children;
        for (TreeNode<Integer> child : children) {
            postOrderTraversal(child);
        }
        System.out.print(root.data + " ");
    }

    public static void printTreeLevelWise(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        System.out.println(root.data);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> front = q.poll();
                ArrayList<TreeNode<Integer>> children = front.children;
                for (TreeNode<Integer> child : children) {
                    System.out.print(child.data + " ");
                    q.add(child);
                }
            }
            System.out.println();
        }
    }

    public static void printTree(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " : ");
        ArrayList<TreeNode<Integer>> children = root.children;
        for (TreeNode<Integer> child : children) {
            System.out.print(child.data + " ");
        }
        System.out.println();
        for (TreeNode<Integer> child : children) {
            printTree(child);
        }
    }

    static Scanner sc = new Scanner(System.in);

    public static TreeNode<Integer> makeTree() {
        TreeNode<Integer> root = new TreeNode<Integer>(sc.nextInt());
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode<Integer> front = q.poll();
            ArrayList<TreeNode<Integer>> children = front.children;
            
            int c = sc.nextInt();
            for (int i = 0; i < c; i++) {
                TreeNode<Integer> newNode = new TreeNode<Integer>(sc.nextInt());
                children.add(newNode);
                q.add(newNode);
            }
        }
        return root;
    }
}
