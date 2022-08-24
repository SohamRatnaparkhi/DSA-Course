package BinaryTree;

class Traversals extends BinaryTreeUse {
    public static void main(String[] args) {
        
        BinaryTreeNode<Integer> root = makeBinaryTree(0, true, false);
        preOrderTraversal(root); // root -> left -> right
        postOrderTraversal(root); // left -> right -> root
        inOrderTraversal(root); // left -> root -> right 
    }

    private static void inOrderTraversal(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return ;
        }
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }

    private static void postOrderTraversal(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return ;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);
    }

    private static void preOrderTraversal(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return ;
        }
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}

