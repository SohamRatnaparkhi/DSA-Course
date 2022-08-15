// package LinkedList;

import java.util.Scanner;

public class LLUseRec {
    public static void main(String[] args) {
        LinkedListNode<Integer> head = makeLL(null, null);
        print(head);

        LinkedListNode<Integer> insetedNodeHead = insertNode(head, 4, 10);
        print(insetedNodeHead);

        LinkedListNode<Integer> deletedNodeHead = deleteNode(head, 4);
        print(deletedNodeHead);

        LinkedListNode<Integer> reversedNodeHead = reverseNode(head);
        print(reversedNodeHead);

    }

    private static LinkedListNode<Integer> reverseNode(LinkedListNode<Integer> head) {
        
        if (head == null || head.next == null) {
            return head;
        }

        LinkedListNode<Integer> reversedHead = reverseNode(head.next);
        LinkedListNode<Integer> reversedTail = head.next;
        // while (reversedTail.next != null) {
        //     reversedTail = reversedTail.next;
        // }
        reversedTail.next = head;
        reversedTail = reversedTail.next;
        head.next = null;

        return reversedHead;
    }

    private static LinkedListNode<Integer> deleteNode(LinkedListNode<Integer> head, int pos) {
        
        if (head == null) {
            return head;
        }
        
        if (pos == 1) {
            head.next = head.next.next;
            return head;
        }

        LinkedListNode<Integer> smallerNodes = deleteNode(head.next, pos - 1);

        head.next = smallerNodes;
                
        return head;
    }

    private static LinkedListNode<Integer> insertNode(LinkedListNode<Integer> head, int pos, int data) {

        if (head == null) {
            return head;
        }
        if (pos == 0) {
            LinkedListNode<Integer> newNode = new LinkedListNode<>(data);
            newNode.next = head;
            return newNode;
        }

        LinkedListNode<Integer> smallerNode = insertNode(head.next, pos - 1, data);

        head.next = smallerNode;

        return head;
    }

    private static void print(LinkedListNode<Integer> head) {
        if (head == null) {
            System.out.println("END");
            return;
        }
        System.out.print(head.data + " --> ");
        print(head.next);

        return;
    }

    static Scanner sc = new Scanner(System.in);

    private static LinkedListNode<Integer> makeLL(LinkedListNode<Integer> tail, LinkedListNode<Integer> head) {
        int data = sc.nextInt();
        LinkedListNode<Integer> newNode = new LinkedListNode<>(data);
        if (data == -1) {
            return head;
        }
        if (head == null) {
            head = newNode;
            tail = newNode;
            return makeLL(tail, head);
        } else {
            tail.next = newNode;
            tail = tail.next;
            return makeLL(tail, head);
        }
        // return head;
    }
}
