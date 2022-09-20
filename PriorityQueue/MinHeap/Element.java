package PriorityQueue.MinHeap;

public class Element<T> {
    
    int priority;
    T value;

    public Element(int priority, T value) {
        this.priority = priority;
        this.value = value;
    }
}
