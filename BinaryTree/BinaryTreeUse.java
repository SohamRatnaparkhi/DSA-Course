package BinaryTree;

import java.util.Scanner;

public class BinaryTreeUse {
    public static void main(String[] args) {

        // BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
        // BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<Integer>(2);
        // BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<Integer>(3);
        
        // root.left = rootLeft;
        // root.right = rootRight;

        // rootLeft.left = new BinaryTreeNode<Integer>(4);
        // rootRight.right = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> root = makeBinaryTree(0, true, false);

        printTree(root);
    }
    
    static Scanner sc = new Scanner(System.in);

    public static BinaryTreeNode<Integer> makeBinaryTree(int data, boolean isRoot, boolean isLeft) {
        if (isRoot) {
            System.out.print("Enter root data - ");
        } else {
            if (isLeft) {
                System.out.print("Enter left node data of " + data + " - ");
            } else {
                System.out.print("Enter right node data of " + data + " - ");
            }
        }
        int d = sc.nextInt();
        
        if(d == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(d);
        BinaryTreeNode<Integer> rootLeft = makeBinaryTree(d, false, true);
        BinaryTreeNode<Integer> rootRight = makeBinaryTree(d, false, false);

        root.left = rootLeft;
        root.right = rootRight;

        return root;

    }
    
    public static void printTree(BinaryTreeNode<Integer> root) {
        // Base condition
        if (root == null) {
            return;
        }
        System.out.print(root.data + " : ");
        if (root.left != null) {
            System.out.print("L - " + root.left.data);
        } else {
            System.out.print("L - " + "null");
        }
        if (root.right != null) {
            System.out.println(", R - " + root.right.data);
        } else {
            System.out.println(", R - " + "null");
        }
        
        printTree(root.left);
        printTree(root.right);

    }
}
