package BinaryTree;

import java.util.ArrayList;

public class CreateTree2 extends LevelwiseTree{
    public static void main(String[] args) {
        System.out.print("Height - ");
        int height = sc.nextInt();
        int[] inorder = new int[height]; 
        int[] preorder = new int[height]; 
        System.out.println("Inorder");
        for (int i = 0; i < height; i++) {
            inorder[i] = sc.nextInt();
        }
        System.out.println("Preorder");
        for (int i = 0; i < height; i++) {
            preorder[i] = sc.nextInt();
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>();
        root = createTree(inorder, preorder);
        printTree(root);
        printLevelWise(root);
    }
    private static BinaryTreeNode<Integer> createTree(int[] inorder, int[] preorder) {
        if (inorder.length == 0 || preorder.length == 0) {
            return null;
        }
        int currRoot = preorder[0];
        ArrayList<Integer> leftIO  = new ArrayList<>();
        ArrayList<Integer> leftPO  = new ArrayList<>();
        ArrayList<Integer> rightIO  = new ArrayList<>();
        ArrayList<Integer> rightPO  = new ArrayList<>();

        boolean rootFound = false;
        int i = 0;
        while (i < inorder.length) {
            if (inorder[i] == currRoot) {
                rootFound = true;
                i++;
                continue;
            }
            if (rootFound) {
                rightIO.add(inorder[i]);
            } else {
                leftIO.add(inorder[i]);
            }
            i++;
        }

        int j = 1;
        while (j < preorder.length) {
            while (j < preorder.length && j <= leftIO.size()) {
                leftPO.add(preorder[j]);
                j++;
            }
            while (j < preorder.length && j - leftPO.size() <= rightIO.size()) {
                rightPO.add(preorder[j]);
                j++;
            }
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(currRoot);
        root.left = createTree(array(leftIO), array(leftPO));
        root.right = createTree(array(rightIO), array(rightPO));
        return root;
    }
    private static int[] array(ArrayList<Integer> l) {
        int[] arr = new int[l.size()];
        int k = 0;
        for (int i: l) {
            arr[k++] = i;
        } 
        return arr;
    }
}
