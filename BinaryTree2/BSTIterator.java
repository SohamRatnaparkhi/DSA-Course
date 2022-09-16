package BinaryTree2;

import java.util.Stack;

public class BSTIterator {

    Stack<BinaryTreeNode<Integer>> s = new Stack<>();
    boolean reverse = true;

    public BSTIterator(BinaryTreeNode<Integer> root, boolean reverse) {
        this.reverse = reverse;
        pushAll(root, reverse);
    }

    public void pushAll(BinaryTreeNode<Integer> root, boolean reverse) {
        while (root != null) {
            s.push(root);
            if (reverse) {
                root = root.right;
                // s.push(root.right);
            } else {
                root = root.left;
                // s.push(root.left);
            }
        }
    }

    public int next() {
        BinaryTreeNode<Integer> ans = s.pop();
        if(reverse == true) 
            pushAll(ans.left, reverse); 
        else
            pushAll(ans.right, reverse);
        return ans.data;
    }
}
