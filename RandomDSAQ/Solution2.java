import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2 {
    public static void main(String[] args) {
        String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
        int k = 3;
        System.out.println(topKFrequent(words, k));
    }
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> wrapper = new ArrayList<>();
        if (words == null || words.length == 0) {
            return wrapper;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        Heap pq = new Heap();

        for (String word : map.keySet()) {
            int freq = map.get(word);
            Tuple e = new Tuple(word, freq);
            pq.insert(e);
        }

        while (!pq.isEmpty()) {
            Tuple w = pq.remove();
            System.out.println(w.word + " - " + w.priority);
        }
        return wrapper;
    }
}

class Tuple {
    String word;
    int priority;

    public Tuple(String word, int priority) {
        this.word = word;
        this.priority = priority;
    }

    public Tuple() {
        word = "";
        priority = 0;
    }
}

class Heap {
    ArrayList<Tuple> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    public void insert(Tuple e) {
        int p = e.priority;
        String w = e.word;
        heap.add(e);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex >= 0) {
            Tuple parent = heap.get(parentIndex);
            Tuple child = heap.get(childIndex);
            int pp = parent.priority;
            String pw = parent.word;
            int cp = child.priority;
            String cw = child.word;

            if (pp == cp) {
                int lex = pw.compareTo(cw);
                if (lex > 0) {
                    Tuple temp = parent;
                    heap.set(parentIndex, child); // parent = child;
                    heap.set(childIndex, temp); // child = parent;
                } else {
                    return;
                }
            } else {
                if (pp < cp) {
                    Tuple temp = parent;
                    heap.set(parentIndex, child); // parent = child;
                    heap.set(childIndex, temp); // child = parent;
                } else {
                    return;
                }
            }

            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;

        }
    }

    public Tuple remove() {
        if (!heap.isEmpty()) {
            Tuple max = heap.get(0);
            heap.set(0, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);

            int pi = 0;

            while (pi < heap.size()) {
                int lchi = 2 * pi + 1;
                int rchi = 2 * pi + 2;
                int swap = -1;
                if (lchi < heap.size()) {
                    if (heap.get(pi).priority < heap.get(lchi).priority) {
                        swap = lchi;
                    } else if (heap.get(pi).priority == heap.get(lchi).priority
                            && heap.get(pi).word.compareTo(heap.get(lchi).word) > 0) {
                        swap = lchi;
                    }
                }
                if (rchi < heap.size()) {
                    if (heap.get(pi).priority < heap.get(rchi).priority) {
                        swap = rchi;
                    } else if (heap.get(pi).priority == heap.get(rchi).priority
                            && heap.get(pi).word.compareTo(heap.get(rchi).word) > 0) {
                        swap = rchi;
                    }
                }
                if (swap == -1)
                    break;

                Tuple temp = heap.get(swap);
                heap.set(swap, heap.get(pi));
                heap.set(pi, temp);

                pi = swap;
            }

            return max;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

}