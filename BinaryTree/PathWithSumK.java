import java.util.Scanner;

public class PathWithSumK extends LevelwiseTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        printLevelWise(root);
        pathSumK(root, "", sc.nextInt());
    }

    static Scanner sc = new Scanner(System.in);

    private static void pathSumK(BinaryTreeNode<Integer> root, String path, int k) {
        if (root == null) {
            return;
        }
        path += root.data + " ";
        if (k == root.data) {
            if (isLeaf(root)) {
                System.out.println(path);
            } else {
                path = "";
            }
        }
        pathSumK(root.left, path, k - root.data);
        pathSumK(root.right, path, k - root.data);

    }

    private static boolean isLeaf(BinaryTreeNode<Integer> root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }
}
