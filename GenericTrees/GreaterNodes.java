package GenericTrees;

import java.util.ArrayList;

public class GreaterNodes extends GenericTree {
    public static void main(String[] args) {
        TreeNode<Integer> root = makeTree();
        printTreeLevelWise(root);
        int ans = numNodeGreater(root,sc.nextInt());
        System.out.println(ans);
    }

    private static int numNodeGreater(TreeNode<Integer> root, int x) {
        if (root == null) {
            return 0;
        }
        int c = root.data > x ? 1 : 0;
        // if(root.data > x)
        //     System.out.println(root.data);

        ArrayList<TreeNode<Integer>> children = root.children;
        // int temp = 0;
        for (TreeNode<Integer> child : children) {
                c += numNodeGreater(child, x);
        }
        return c;
    }
}
