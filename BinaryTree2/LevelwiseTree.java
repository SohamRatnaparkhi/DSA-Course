package BinaryTree2;

// package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelwiseTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        // printTree(root);
        printLevelWise(root);
    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> pendingElements = new LinkedList<>();
        if (root != null) {
            pendingElements.add(root);
        }
        int level = 1;
        while (!pendingElements.isEmpty()) {
            int queueLength = pendingElements.size();
            System.out.print("Level " + level + " : ");
            for (int i = 0; i < queueLength; i++) {
                BinaryTreeNode<Integer> front = pendingElements.poll();
                System.out.print(front.data + " ");
                if (front.left != null) {
                    pendingElements.add(front.left);
                } 
                if (front.right != null) {
                    pendingElements.add(front.right);
                } 
            }
            System.out.println();
            level++;
        }
    }

    public static void printTree(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> pendingElements = new LinkedList<>();
        if (root != null) {
            pendingElements.add(root);
        }
        while (!pendingElements.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingElements.poll();
            if (front != null) {
                System.out.print(front.data + " : ");
                if (front.left != null) {
                    System.out.print("L - " + front.left.data + ", ");
                    pendingElements.add(front.left);
                }
                if (front.right != null) {
                    System.out.print("R - " + front.right.data);
                    pendingElements.add(front.right);
                }
                System.out.println();
            }
        }
    }

    static Scanner sc = new Scanner(System.in);

    public static BinaryTreeNode<Integer> makeTree() {
        System.out.print("Enter elements level wise - ");
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(data);
        Queue<BinaryTreeNode<Integer>> pendingElements = new LinkedList<>();
        pendingElements.add(root);
        while (!pendingElements.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingElements.poll();
            // System.out.print("Enter left of " + front.data + " - ");
            int left = sc.nextInt();
            if (left != -1) {
                front.left = new BinaryTreeNode<>(left);
                pendingElements.add(front.left);
            }
            // System.out.print("Enter right of " + front.data + " - ");
            int right = sc.nextInt();
            if (right != -1) {
                front.right = new BinaryTreeNode<>(right);
                pendingElements.add(front.right);
            }
        }
        return root;
    }
}
