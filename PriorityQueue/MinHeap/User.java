package PriorityQueue.MinHeap;

public class User {
    public static void main(String[] args) {
        PriorityQueue<Integer> p = new PriorityQueue<Integer>();
        for (int i = 1; i < 8; i++) {
            p.insert(i, i);            
        }
        p.print();
        while (!p.isEmpty()) {
            int x = p.removeMin();
            System.out.println("Removed element = " + x);
            p.print();
        }
    }
}
