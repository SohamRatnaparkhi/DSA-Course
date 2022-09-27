package PriorityQueue;

import java.util.ArrayList;
import java.util.HashMap;

public class Ticket {

    public static void main(String[] args) {
        // int[] input = { 3, 9, 4 };
        // int k = 2;
        int[] input = { 2, 3, 2, 2, 4 };
        int k = 3;
        int ans = buyTicket(input, k);
        System.out.println(ans);
    }

    public static int buyTicket(int input[], int k) {
        /*
         * Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        int ans = 0;
        ArrayList<Tuple> l = new ArrayList<>();
        for (int i : input) {
            if (k == 1) {
                l.add(new Tuple(i));
            } else {
                l.add(new Tuple(i));
            }
        }
        Tuple key = l.get(k);
        key.key = true;
        l.set(k, key);
        PriorityQueue p = new PriorityQueue();
        // HashMap<Integer, Integer> freq = new HashMap<>();
        for (Tuple e : l) {
            int i = e.element;
            p.insert(e, i);
        }
        // for (int i : input) {
        // if (freq.get(i) != null) {
        // p.insert(i, i - freq.get(i));
        // freq.put(i, freq.get(i) + 1);
        // } else {
        // freq.put(i, 1);
        // p.insert(i, i);
        // }
        // }
        // p.print();
        while (!p.isEmpty()) {
            int top = p.getTop().element;
            for (int i = 0; i < l.size(); i++) {
                if (l.get(i).element < top) {
                    Tuple temp = l.remove(i);
                    l.add(temp);
                } else {
                    if (l.get(i).element == top) {
                        if (l.get(i).key) {
                            ans++;
                            return ans;
                        }
                    }
                    l.remove(i);
                    p.removeTop();
                    top = p.getTop().element;
                    ans++;
                }
            }
        }
        return ans;
    }

}

class Tuple {
    int element;
    boolean key = false;

    public Tuple(int element) {
        this.element = element;
    }

    public Tuple(int element, boolean key) {
        this.element = element;
        this.key = key;
    }

    public void print() {
        System.out.println(element + " - " + key);
    }
}

class Element {

    int priority;
    Tuple value;

    Element(int priority, Tuple value) {
        this.priority = priority;
        this.value = value;
    }
}

class PriorityQueue {

    private ArrayList<Element> heap;

    PriorityQueue() {
        heap = new ArrayList<>();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void print() {
        // System.out.println("v - p");
        for (Element e : heap) {
            System.out.println(e.value.element + " - " + e.value.key + " - " + e.priority);
        }
    }

    public Tuple getTop() {
        return heap.get(0).value;
    }

    public void insert(Tuple value, int priority) {
        heap.add(new Element(priority, value));
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (parentIndex >= 0) {
            if (heap.get(childIndex).priority > heap.get(parentIndex).priority) {
                swap(childIndex, parentIndex);
                childIndex = parentIndex;
            } else {
                return;
            }
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
    }

    public Tuple removeTop() {
        Element rem = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int parent = 0;
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        while (left < heap.size() && right < heap.size()) {
            int swappedIndex = -1;
            if (heap.get(parent).priority < heap.get(left).priority) {
                swap(parent, left);
                swappedIndex = left;
            }
            if (heap.get(parent).priority < heap.get(right).priority) {
                swap(parent, right);
                swappedIndex = right;
            }
            if (swappedIndex == -1) {
                return rem.value;
            }
            parent = swappedIndex;
            left = 2 * parent + 1;
            right = 2 * parent + 2;

        }
        return rem.value;
    }

    private void swap(int childIndex, int parentIndex) {
        Element temp = heap.get(childIndex);
        heap.set(childIndex, heap.get(parentIndex));
        heap.set(parentIndex, temp);
    }

}