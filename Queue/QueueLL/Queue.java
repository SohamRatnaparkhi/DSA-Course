package Queue.QueueLL;

public class Queue {

    private Node front;
    private Node rear;
    private int size;

    public Queue() {
        // Implement the Constructor
        front = null;
        rear = null;
        size = 0;
    }

    /*----------------- Public Functions of Stack -----------------*/

    public int getSize() {
        // Implement the getSize() function
        return this.size;
    }

    public boolean isEmpty() {
        // Implement the isEmpty() function
        return this.size == 0;
    }

    public void enqueue(int data) {
        // Implement the enqueue(element) function
        Node newNode = new Node(data);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = rear.next;
        }
        this.size++;
    }

    public int dequeue() {
        // Implement the dequeue() function
        if (this.size != 0) {
            Node deletedNode = front;
            front = front.next;
            this.size--;
            return deletedNode.data;
        } else {
            this.size--;
            return -1;
        }
    }

    public int front() {
        // Implement the front() function
        return this.size == 0 ? -1 : this.front.data;
    }
}
