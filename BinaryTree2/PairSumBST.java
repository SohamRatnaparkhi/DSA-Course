package BinaryTree2;

import java.util.Stack;

public class PairSumBST extends LevelwiseTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        int sum = sc.nextInt();
        BSTIterator iterator1 = new BSTIterator(root, false);
        BSTIterator iterator2 = new BSTIterator(root, true);
        pairSum(iterator1, iterator2, sum);
    }

    private static void pairSum(BSTIterator iterator1, BSTIterator iterator2, int sum) {
        int i = iterator1.next();
        int j = iterator2.next();
        while (i < j) {
            int k = i + j;
            if(k == sum) {
                System.out.println(i + " " + j);
                i = iterator1.next();
                j = iterator2.next();
            }
            if (k < sum)
                i = iterator1.next();
            else if (k > sum)
                j = iterator2.next();
        }
    }
}

class BSTIterator {

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
        if (reverse == true)
            pushAll(ans.left, reverse);
        else
            pushAll(ans.right, reverse);
        return ans.data;
    }
}