import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ConnectedComps extends Traversals{
    
    static Scanner sc = new Scanner(System.in);     
    public static void main(String[] args) {
        ArrayList<PriorityQueue<Integer>> al = makeAlGraph(sc.nextInt(), sc.nextInt());
        ArrayList<Integer> disconnectedComps = new ArrayList<>();
        System.out.println("Connected comps are - ");
        findConnectedComps(al, al.size(), 0, new boolean[al.size()], disconnectedComps);
        System.out.println(disconnectedComps);
    }
    private static void findConnectedComps(ArrayList<PriorityQueue<Integer>> al, int v, int currNode, boolean[] visited, ArrayList<Integer> disconnectedComps) {
        // use basic dfs traversal
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                disconnectedComps.add(i);
                dfsTraversal(al, i, visited);
                System.out.println();
            }
        }

    }
    private static void dfsTraversal(ArrayList<PriorityQueue<Integer>> al, int i, boolean[] visited) {
        visited[i] = true;
        System.out.print(i + " ");
        for (int node : al.get(i)) {
            if (!visited[node]) {
                visited[node] = true;
                dfsTraversal(al, node, visited);
            }
        }
    }
}