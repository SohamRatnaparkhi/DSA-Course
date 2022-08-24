
 package LinkedList;

import java.util.Scanner;

public class DynamicLL {
    public static void main(String[] args) {

        Node head = dynamicLLOptimized();
        print(head);

        Node newHead = insertNode(head, 3, 0);
        print(newHead);

        // Node afterDel = deleteNode(head, 3234);
        // print(afterDel);

    }

    private static Node deleteNode(Node head, int pos) {

        int i = 0;
        Node prevNode = head;

        if (pos == 0) {
            head = head.next;
            return head;
        }

        while (i < pos - 1 && prevNode.next != null) {
            prevNode = prevNode.next;
            ++i;
        }
        Node remNode = prevNode.next;
        if (remNode == null) {
            return head;
        }
        prevNode.next = remNode.next;
        remNode.next = null;

        return head;
    }

    private static Node insertNode(Node head, int pos, int data) {
        Node addingNode = new Node(data);
        Node prevNode = head;
        int i = 0;
        if (pos == 0) {
            addingNode.next = head;
            head = addingNode;
            return head;
        }
        while (i < pos - 1) {
            prevNode = prevNode.next;
            ++i;
        }
        Node nextNode = prevNode.next;
        addingNode.next = nextNode;
        prevNode.next = addingNode;

        return head;
        // return null;
    }

    public static Node print(Node head) {
        if (head == null) {
            System.out.print("tail\n");
            return null;
        }
        System.out.print(head.data);
        System.out.print(" --> ");

        return print(head.next);

    }

    static Scanner sc = new Scanner(System.in);

    public static Node dynamicLL() {

        int data = sc.nextInt();
        Node head = null;

        while (data != -1) {
            Node currentNode = new Node(data);
            if (head == null) {
                head = currentNode;
            } else {
                Node tail = head;
                while (tail.next != null) {
                    tail = tail.next;
                }
                tail.next = currentNode;
            }
            data = sc.nextInt();
        }
        return head;
    }

    public static Node dynamicLLOptimized() {
        int data = sc.nextInt();
        Node head = null, tail = new Node();
        while (data != -1) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
            data = sc.nextInt();
        }
        return head;
    }

}
