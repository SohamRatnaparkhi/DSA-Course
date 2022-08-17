public class MinMax extends LevelwiseTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        printTree(root);
        Pair<Integer, Integer> ans = getMinAmdMax(root);
        System.out.println("_______________________");
        System.out.println(ans.maximum + " " + ans.minimum);
    }
    
    private static Pair<Integer, Integer> getMinAmdMax(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return new Pair<>(Integer.MAX_VALUE, -1);
        }
        Pair<Integer, Integer> ans = new Pair<>(0, 0);

        int leftMax = getMinAmdMax(root.left).maximum;
        int leftMin = getMinAmdMax(root.left).minimum;
        
        int rightMax = getMinAmdMax(root.right).maximum;
        int rightMin = getMinAmdMax(root.right).minimum;

        ans.maximum = Math.max(root.data, Math.max(leftMax, rightMax));
        ans.minimum = Math.min(root.data, Math.min(leftMin, rightMin));

        return ans;
    }
}

class Pair<T, U> {
    T minimum;
    U maximum;

    public Pair(T minimum, U maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

}