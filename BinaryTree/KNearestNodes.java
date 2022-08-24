// // import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.LinkedList;
// import java.util.Queue;

// public class KNearestNodes extends LevelwiseTree {
//     public static void main(String[] args) {
//         BinaryTreeNode<Integer> root = makeTree();
//         printLevelWise(root);
//         kNode(root, sc.nextInt(), sc.nextInt());
//     }

//     private static void kNode(BinaryTreeNode<Integer> root, int node, int k) {
//         HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parents = new HashMap<>();
//         setParents(parents, root);
//         BinaryTreeNode<Integer> target = dfs(node, root);
//         Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
//         HashMap<BinaryTreeNode<Integer>, Boolean> visited = new HashMap<>();
//         q.add(target);
//         visited.put(target, true);

//         int c = 0;
//         while (!q.isEmpty()) {
//             int size = q.size();
//             if(c == k)
//                 break;
//             for (int i = 0; i < size; i++) {
//                 BinaryTreeNode<Integer> front = q.poll();
//                 if (front.left != null && visited.get(front.left) == null) {
//                     q.add(front.left);
//                     visited.put(front.left, true);
//                 }
//                 if (front.right != null && visited.get(front.right) == null) {
//                     q.add(front.right);
//                     visited.put(front.right, true);
//                 }
//                 if(parents.get(front) != null && visited.get((parents.get(front))) == null) {
//                     q.add((parents.get(front)));
//                     visited.put((parents.get(front)),true);
//                 }
//             }
//             c++;
//         }
//         while (! q.isEmpty()) {
//             System.out.println(q.poll().data);
//         }
//     }

//     private static BinaryTreeNode<Integer> dfs(int node, BinaryTreeNode<Integer> root) {
//         if (root == null) {
//             return null;
//         }
//         if (root.data == node)
//             return root;

//         BinaryTreeNode<Integer> left = dfs(node, root.left);
//         if (left != null) {
//             return left;
//         }
//         BinaryTreeNode<Integer> right = dfs(node, root.right);
//         return right;
//     }

//     private static void setParents(HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parents,
//             BinaryTreeNode<Integer> root) {
//         if (root == null) {
//             return;
//         }
//         Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
//         q.add(root);
//         while (!q.isEmpty()) {
//             BinaryTreeNode<Integer> front = q.poll();
//             if (front.left != null) {
//                 q.add(front.left);
//                 parents.put(front.left, front);
//             }
//             if (front.right != null) {
//                 q.add(front.right);
//                 parents.put(front.right, front);
//             }
//         }
//     }
// }
