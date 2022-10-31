package BinaryTree2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
// import java.util.ArrayList;

public class VerticalTraversal extends LevelwiseTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        printLevelWise(root);
        System.out.println("x y data");
        verticalTraversal(root);
    }

    static int minX = Integer.MAX_VALUE;
    static int maxX = Integer.MIN_VALUE;

    private static void verticalTraversal(BinaryTreeNode<Integer> root) {
        Map<Integer, Map<Integer, ArrayList<Integer>>> mp = new HashMap<>();
        mapMake(root, 0, 0, mp);
        System.out.println(mp);
        // for (Integer i : mp.keySet()) {
        // int x = i;
        // Map<Integer, ArrayList<Integer>> ymap = mp.get(x);
        // for (Integer j : ymap.keySet()) {
        // int y = j;
        // ArrayList<Integer> q = ymap.get(y);
        // for (Integer binaryTreeNode : q) {
        // System.out.println(x + " " + y + " " + binaryTreeNode);
        // }
        // }
        // }
        System.out.println(minX + "  "  + maxX );
        for (int i = minX; i <= maxX; i++) {
            int x = i;
            Map<Integer, ArrayList<Integer>> ymap = mp.get(x);
            for (Integer j : ymap.keySet()) {
                int y = j;
                ArrayList<Integer> q = ymap.get(y);
                for (Integer binaryTreeNode : q) {
                    System.out.println(binaryTreeNode);
                }
            }
        }
    }

    private static void mapMake(BinaryTreeNode<Integer> root, int x, int y,
            Map<Integer, Map<Integer, ArrayList<Integer>>> mp) {
        if (root == null) {
            return;
        }
        // Group grp = new Group(root, x, y);
        if (!mp.containsKey(x)) {
            mp.put(x, new HashMap<>());
        }
        if (!mp.get(x).containsKey(y)) {
            mp.get(x).put(y, new ArrayList<>());
        }

        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);

        mp.get(x).get(y).add(root.data);
        mapMake(root.left, x - 1, y + 1, mp);
        mapMake(root.right, x + 1, y + 1, mp);
    }
}
