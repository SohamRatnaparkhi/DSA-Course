package LinkedList;

public class ReverseKNodes extends MidPoint {
    public static void main(String[] args) {
        LinkedListNode<Integer> head = makeLL();
        print(head);
        int k = 3;
        LinkedListNode<Integer> kReverse = kReverse(head, k);
        print(kReverse);
    }

    private static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
        LinkedListNode<Integer> newList = null;
        LinkedListNode<Integer> newListTail = null;
        LinkedListNode<Integer> currNode = head;
        // LinkedListNode<Integer> nextNode = null;
        // LinkedListNode<Integer> prevNode = null;

        int c = 0;
        while (currNode != null) {
            LinkedListNode<Integer> tempNode = null;
            LinkedListNode<Integer> tempNodeTail = null;
            while (currNode != null && c < k) {
                if (tempNode == null) {
                    tempNode = currNode;
                    tempNodeTail = currNode;
                } else {
                    tempNodeTail.next = currNode;
                    tempNodeTail = tempNodeTail.next;
                }
                currNode = currNode.next;
                c += 1;
            }
            c = 0;
            head = currNode;
            tempNodeTail.next = null;
            // print(tempNode);
            // print(head);
            LinkedListNode<Integer> reversedTempNode = reverseLL(tempNode);
            // print(reversedTempNode);
            if (newList == null) {
                newList = reversedTempNode;
                newListTail = reversedTempNode;
                while (newListTail.next != null) {
                    newListTail = newListTail.next;
                }
            } else {
                if (newListTail != null) {
                    newListTail.next = reversedTempNode;
                    while (newListTail.next != null) {
                        newListTail = newListTail.next;
                    }
                } 
                // else {
                //     return newList;
                // }               
            }
        }
        return newList;
    }

    private static LinkedListNode<Integer> reverseLL(LinkedListNode<Integer> head) {
        // LinkedListNode<Integer> currNode = head;
        // LinkedListNode<Integer> nextNode = null;
        // LinkedListNode<Integer> prevNode = null;

        // while (currNode != null) {
        // nextNode = currNode.next;
        // currNode.next = prevNode;
        // prevNode = currNode;
        // currNode = currNode.next;
        // }
        // // print(prevNode);
        // return prevNode;
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode<Integer> revesedList = reverseLL(head.next);
        LinkedListNode<Integer> revesedListTail = head.next;
        revesedListTail.next = head;
        revesedListTail = revesedListTail.next;
        head.next = null;

        return revesedList;
    }
}
