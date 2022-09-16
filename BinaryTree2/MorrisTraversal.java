package BinaryTree2;

public class MorrisTraversal extends LevelwiseTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        preOrderMorris(root);
    }

    private static void preOrderMorris(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        if (root.left == null) {
            System.out.println(root.data);
            root = root.right;
        } else {
            BinaryTreeNode<Integer> prev = root.left;
            while (prev.right != null && prev.right != root) {
                prev = prev.right;
            }          
            if (prev.right == null) {
                prev.right = root;
                root = root.left;
            } else {
                System.out.println(root.data);
                prev.right = null;
                root = root.right;
            }
        }
    }
}
