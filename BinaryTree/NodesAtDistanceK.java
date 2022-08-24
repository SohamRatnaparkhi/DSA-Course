package BinaryTree;

public class NodesAtDistanceK extends LevelwiseTree{
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        nodesAtDistanceK(root, sc.nextInt(), sc.nextInt());
    }
    static boolean target = false;
    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        if (root == null) {
            return ;
        }
        if (root.data == node) target = true;
        if(k == 0) {
            System.out.println(root.data);
        }
        if (target) {
            nodesAtDistanceK(root.left, node, k - 1);
            nodesAtDistanceK(root.right, node, k - 1);
        } else {
            nodesAtDistanceK(root.left, node, k);
            nodesAtDistanceK(root.right, node, k);
        }
    }
}
