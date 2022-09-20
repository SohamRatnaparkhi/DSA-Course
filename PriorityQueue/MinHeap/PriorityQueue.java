package PriorityQueue.MinHeap;

import java.util.ArrayList;

public class PriorityQueue<T> {
    
    private ArrayList<Element<T>> heap;

    public PriorityQueue() {
        this.heap = new ArrayList<>();
    }

    public void insert(T value, int priority) {
        heap.add(new Element<T>(priority, value));
        int childIndex = size() - 1;
        int parentIndex = (childIndex - 1) / 2;
        while (childIndex != 0) {
            if (heap.get(parentIndex).priority > heap.get(childIndex).priority) {
                Element<T> temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(childIndex));
                heap.set(childIndex, temp); 
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    public T getMin() {
        return !isEmpty() ? heap.get(0).value : null;
    }

    public T removeMin() {
        if (!isEmpty()) {
            Element<T> minElement = heap.get(0);
            heap.set(0, heap.get(size() - 1));
            heap.remove(size() - 1);
            // System.out.println(heap);
            int parentIndex = 0;
            int childIndex1 = 2 * parentIndex + 1;
            int childIndex2 = 2 * parentIndex + 2;
            
            while (childIndex1 < size() && childIndex2 < size()) {
                
                int parent = heap.get(parentIndex).priority;
                int c1 = heap.get(childIndex1).priority;
                int c2 = heap.get(childIndex2).priority;
                int swappedIndex = -1;

                if (c1 < parent && c1 < c2) {
                    swappedIndex = childIndex1;
                    Element<T> temp = heap.get(childIndex1);
                    heap.set(childIndex1, heap.get(parentIndex));
                    heap.set(parentIndex, temp);    
                } else if (c2 < parent && c2 < c1) {
                    swappedIndex = childIndex2;
                    Element<T> temp = heap.get(childIndex2);
                    heap.set(childIndex2, heap.get(parentIndex));
                    heap.set(parentIndex, temp);    
                } else {
                    break;
                }
                parentIndex = swappedIndex;
                childIndex1 = 2 * parentIndex + 1;
                childIndex2 = 2 * parentIndex + 2;
            }

            return minElement.value;
        } else {
            return null;
        }
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public void print() {
        for (Element<T> e : heap) {
            System.out.println(e.value);
        }
    }

}


class PriorityQueueException extends Exception {

}