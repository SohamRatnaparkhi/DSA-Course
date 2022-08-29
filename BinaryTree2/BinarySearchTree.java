package BinaryTree2;

public class BinarySearchTree {
    BinaryTreeNode<Integer> root;

    public void insert(int data) {
        // Implement the insert() function
        this.root = insertIntoBST(root, data);
    }

    private static BinaryTreeNode<Integer> insertIntoBST(BinaryTreeNode<Integer> root, int val) {
        if (root == null) {
            return new BinaryTreeNode<>(val);
        }

        if (val < root.data)
            root.left = insertIntoBST(root.left, val);
        else
            root.right = insertIntoBST(root.right, val);
        return root;
    }

    public void remove(int data) {
        // Implement the remove() function
        this.root = delNodeinBST(root, data);
    }

    private static BinaryTreeNode<Integer> delNodeinBST(BinaryTreeNode<Integer> root, int i) {
        if (root == null)
            return null;
        if (root.data < i) {
            root.right = delNodeinBST(root.right, i);
        } else if (root.data > i) {
            root.left = delNodeinBST(root.left, i);
        } else {
            if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                root.data = minVal(root.right);
                root.right = delNodeinBST(root.right, root.data);
            }
        }
        return root;
    }

    private static Integer minVal(BinaryTreeNode<Integer> root) {
        while (root.left != null) {
            root = root.left;
        }
        // System.out.println("min data = " + root.data);
        return root.data;
    }

    public void printTree() {
        // Implement the printTree() function
        printBST(root);
    }

    private static void printBST(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        System.out.print(root.data + ":");
        if (root.left != null)
            System.out.print("L:" + root.left.data + ",");
        if (root.right != null)
            System.out.print("R:" + root.right.data);
        System.out.println();
        printBST(root.left);
        printBST(root.right);
        return;
    }

    public boolean search(int data) {
        // Implement the search() function
        return searchBST(root, data);
    }

    private static boolean searchBST(BinaryTreeNode<Integer> root, int data) {
        if (root == null)
            return false;
        if (root.data == data)
            return true;
        if (data < root.data)
            return searchBST(root.left, data);
        else
            return searchBST(root.right, data);

    }
}
