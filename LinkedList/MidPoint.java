// package LinkedList;

import java.util.Scanner;

public class MidPoint {
    public static void main(String[] args) {
        LinkedListNode<Integer> head = makeLL();
        print(head);
        LinkedListNode<Integer> linkedListMidPoint = midPointOfLinkedList(head);
        System.out.println(linkedListMidPoint.data);
    }

    public static LinkedListNode<Integer> midPointOfLinkedList(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        while (true) {
            if (fast.next == null || (fast.next != null && fast.next.next == null)){
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void print(LinkedListNode<Integer> head) {
        if (head == null) {
            System.out.println("END");
            return;
        }
        System.out.print(head.data + " -> ");
        print(head.next);
    }

    static Scanner sc = new Scanner(System.in);

    public static LinkedListNode<Integer> makeLL() {
        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> tail = null;
        int data = sc.nextInt();
        while (data != -1) {
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
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
