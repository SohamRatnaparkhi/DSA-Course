package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.print.attribute.standard.PrintQuality;

import java.util.PriorityQueue;

public class Traversals {
    public static void main(String[] args) {
        System.out.println("Enter v and e");
        int v = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<PriorityQueue<Integer>> al = makeAlGraph(v, e);
        printGraph(al);
        // dfs(al, 0, new boolean[v + 1]);
        bfs(al, 0);
    }

    private static void bfs(ArrayList<PriorityQueue<Integer>> al, int i) {
        Queue<Integer> q = new LinkedList<>();
        // PriorityQueue<Integer> q = new PriorityQueue<>();
        boolean[] visited = new boolean[al.size() + 1];

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            PriorityQueue<Integer> p = al.get(node);
            while(!p.isEmpty()) {
                int currNode = p.poll();
                if (!visited[currNode])
                    q.add(currNode);
                visited[currNode] = true;
            }

        }

    }

    private static void dfs(ArrayList<ArrayList<Integer>> al, int node, boolean[] visited) {
       
        visited[node] = true;
        System.out.println(node);

        for (int currNode : al.get(node)) {
            if(!visited[currNode])
            dfs(al, currNode, visited);
        }

    }

    static Scanner sc = new Scanner(System.in);

    public static ArrayList<PriorityQueue<Integer>> makeAlGraph(int v, int e) {
        ArrayList<PriorityQueue<Integer>> al = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            al.add(new PriorityQueue<>());
        }
        System.out.println("Enter 'e' queries:");
        for (int i = 0; i < e; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            al.get(m).add(n);
            al.get(n).add(m);
        }
        return al;
    }

    public static void printGraph(ArrayList<PriorityQueue<Integer>> al) {
        int i = 0;
        for (PriorityQueue<Integer> arrayList : al) {
            System.out.print(i++ + " - ");
            System.out.println(arrayList);
        }
    }

}
