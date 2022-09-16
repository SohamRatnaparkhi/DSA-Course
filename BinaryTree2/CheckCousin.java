package BinaryTree2;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCousin extends LevelwiseTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        System.out.println(checkCousins(root, sc.nextInt(), sc.nextInt()));   
    }

    private static boolean checkCousins(BinaryTreeNode<Integer> root, int p, int q) {
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int s = queue.size();
            boolean x = false, y = false;
            for (int i = 0; i < s; i++) {
                BinaryTreeNode<Integer> front = queue.poll();
                if ((front.left != null && front.right != null) && (front.left.data == p && front.right.data == q)) {
                    return false;
                }
                if (front.data == p) {
                    x = true;
                }
                if (front.data == q) {
                    y = true;
                }
                if (x && y) {
                    return true;
                }
                if (front.left != null) {
                    queue.add(front.left);
                }

                if (front.right != null) {
                    queue.add(front.right);
                }

            }
            if (x && y) {
                return true;
            }
        }
        return false;
    }
}
