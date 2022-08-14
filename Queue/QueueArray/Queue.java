package Queue.QueueArray;

public class Queue {
    private int[] data;
    private int size;
    private int front, rear;

    public Queue() {
        super();
        this.data = new int[5];
        this.size = 0;
        this.front = -1;
        this.rear = -1;
    }

    public Queue(int capacity) {
        super();
        this.data = new int[capacity];
        this.size = 0;
        this.front = -1;
        this.rear = -1;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void enqueue(int element) {
        this.data[this.size++] = element;
        if (size == 1) {
            this.front++;
            this.rear++;
        } else {
            this.rear++;
        }
    }

    public int dequeue() {
        this.size--;
        return data[this.front++];
    }

    public int front() {
        return front;
    }

    public int rear() {
        return rear;
    }
}
