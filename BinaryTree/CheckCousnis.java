import java.util.LinkedList;
import java.util.Queue;

public class CheckCousnis extends LevelwiseTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        printLevelWise(root);
        System.out.println("Enter cousins to check");
        boolean ans = checkCousins(root, sc.nextInt(), sc.nextInt());
        System.out.println(ans);
    }

    private static boolean checkCousins(BinaryTreeNode<Integer> root, int x, int y) {
        if (root == null)
            return false;
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int s = q.size();
            boolean checkX = true;
            boolean checkY = true;
            // boolean check = true;
            for (int i = 0; i < s; i++) {
                BinaryTreeNode<Integer> front = q.poll();
                if (front.left != null && front.right != null) {
                    if (front.left.data == x) {
                        if (front.right.data == y) {
                            return false;
                        }
                    } else if (front.right.data == x) {
                        if (front.left.data == y) {
                            return false;
                        }
                    }
                }
                if (checkX && checkY) {
                    if (front.data == x) 
                        checkX = false;
                    
                    if (front.data == y) 
                        checkY = false;
                }
                if (checkY) {
                    if (front.data == y) 
                        checkY = false;
                }
                if (checkX) {
                    if(front.data == x)
                        checkX = false;
                }
                if (!checkX && !checkY) {
                    return true;
                }
                if (front.left != null) {
                    q.add(front.left);
                } 
                if (front.right != null) {
                    q.add(front.right);
                }
            }
        }
        return false;
    }

}
