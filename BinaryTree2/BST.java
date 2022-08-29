package BinaryTree2;

public class BST extends LevelwiseTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        printTree(root);
        System.out.println("_______");
        System.out.print("Enter node to delete - ");
        BinaryTreeNode<Integer> delNode = delNodeinBST(root, sc.nextInt());
        printTree(delNode);
        // BinaryTreeNode<Integer> addNode = insertIntoBST(root, 3);
        // printTree(addNode);
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

    private static Integer minVal(BinaryTreeNode<Integer> root) {
        while (root.left != null) {
            root = root.left;
        }
        // System.out.println("min data = " + root.data);
        return root.data;
    }

    public static boolean isLeaf(BinaryTreeNode<Integer> root) {
        return root.left == null && root.right == null;
    }
}
