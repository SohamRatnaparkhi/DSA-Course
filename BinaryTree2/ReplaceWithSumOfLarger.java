package BinaryTree2;

import BinaryTree.BinaryTreeNode;
import BinaryTree.LevelwiseTree;

public class ReplaceWithSumOfLarger extends LevelwiseTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        printLevelWise(root);
        sumReplace(root, 0);
        printLevelWise(root);
    }

    private static int sumReplace(BinaryTreeNode<Integer> root, int sum) {
        if (root == null)
            return 0;

            int x = root.data;
        int rs = sumReplace(root.right, sum);
        root.data += sum + rs;
        int ls = sumReplace(root.left, root.data);

        return rs + x + ls;
        
    }
}
