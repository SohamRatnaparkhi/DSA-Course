package Stack;

public class Stack {

    private int size;
    private Node head;

    public Stack() {
        // Implement the Constructor
        this.size = 0;
        this.head = null;
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

    public void push(int element) {
        // Implement the push(element) function
        // ? newNode -> head
        Node newNode = new Node(element);
        newNode.next = this.head;
        this.head = newNode;
    }

    public int pop() {
        // Implement the pop() function
        int value = this.head.data;
        this.head = this.head.next;
        return value;

    }

    public int top() {
        // Implement the top() function
        return this.head.data;
    }
}
