package LinkedList;

public class LC_25 extends MidPoint {
    public static void main(String[] args) {
        LinkedListNode<Integer> head = makeLL();
        LinkedListNode<Integer> newHead = reverseKGroup(head, 3);
        print(newHead);
    }

    private static LinkedListNode<Integer> reverseKGroup(LinkedListNode<Integer> head, int k) {
        int length = lengthLL(head);
        // int n = length / k;
        // LinkedListNode<Integer> currNode = head;
        
        return head;
    }

    private static int lengthLL(LinkedListNode<Integer> head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    private static LinkedListNode<Integer> reverseLL(LinkedListNode<Integer> head, int k) {
        
        LinkedListNode<Integer> prev = null, next = null;
        LinkedListNode<Integer> curr = head;

        while (curr != null && k-- > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
