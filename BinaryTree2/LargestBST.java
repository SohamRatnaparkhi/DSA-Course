package BinaryTree2;

public class LargestBST extends LevelwiseTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        printTree(root);
        printLevelWise(root);
        System.out.println("------------");
        int x = largestBST(root);
        System.out.println(x);
    }

    private static int largestBST(BinaryTreeNode<Integer> root) {
        NodeDetails height = largestSubtree(root);
        return height.height;
    }

    private static NodeDetails largestSubtree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new NodeDetails(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        NodeDetails left = largestSubtree(root.left);
        NodeDetails right = largestSubtree(root.right);

        if (left.max < root.data && root.data < right.min) {
            return new NodeDetails(1 + Math.max(left.height, right.height), right.max, left.min);
        } else {
            return new NodeDetails(Math.max(left.height, right.height), Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
    }
}

class NodeDetails {
    int height;
    int max;
    int min;

    public NodeDetails(int height, int max, int min) {
        this.height = height;
        this.max = max;
        this.min = min;
    }
}