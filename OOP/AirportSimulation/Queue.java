package OOP.AirportSimulation;

public class Queue {
    LinkedListNode queue;
    LinkedListNode tail;
    boolean isActive = false;
    int length;

    public Queue() {
        queue = null;
        tail = null;
        length = 0;
    }

    public void add(Request data) {
        LinkedListNode newNode = new LinkedListNode();
        newNode.data = data;
        if (queue == null) {
            queue = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        length++;
    }

    public Request poll() {
        if (queue != null) {
            Request top = queue.data;
            queue = queue.next;
            length--;
            return top;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public Request top() {
        if (length == 0) {
            return null;
        }
        return this.queue.data;
    }

    public void print() {
        LinkedListNode temp = queue;
        while (temp != null) {
            temp.data.print();
            temp = temp.next;
        }
    }
}
