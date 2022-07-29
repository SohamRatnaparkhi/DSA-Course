package LinkedList;

public class MergeSort extends MidPoint {

    public static void main(String[] args) {
        LinkedListNode<Integer> head = makeLL();
        // LinkedListNode<Integer> midPoint = midPointOfLinkedList(head);
        // LinkedListNode<Integer> right = divideLL(head, midPoint, false);
        // print(right);
        // LinkedListNode<Integer> left = divideLL(head, midPoint, true);
        // print(left);

        LinkedListNode<Integer> sortedList = divideLL(head);
        print(sortedList);
    }

    private static LinkedListNode<Integer> divideLL(LinkedListNode<Integer> head) {
        if (length(head, 0) == 0 || length(head, 0) == 1) {
            return head;
        }
        LinkedListNode<Integer> midPoint = midPointOfLinkedList(head);
        LinkedListNode<Integer> headRight = head;
        LinkedListNode<Integer> headLeft = midPoint.next;
        midPoint.next = null;
        LinkedListNode<Integer> right = divideLL(headRight);
        // print(right);
        LinkedListNode<Integer> left = divideLL(headLeft);
        // print(left);
        return mergeLL(left, right);
    }

    private static int length(LinkedListNode<Integer> head, int length){
        if(head == null){
            return length;
        }
        length += 1;
        return length(head.next, length);
    }
    
    private static LinkedListNode<Integer> mergeLL(LinkedListNode<Integer> left, LinkedListNode<Integer> right) {
        LinkedListNode<Integer> mergedListHead = null;
        LinkedListNode<Integer> mergedListTail = null;

        LinkedListNode<Integer> l = left;
        LinkedListNode<Integer> r = right;

        while (l != null && r != null) {
            if (l.data <= r.data) {
                if (mergedListHead == null) {
                    mergedListHead = l;
                    mergedListTail = l;
                } else {
                    mergedListTail.next = l;
                    mergedListTail = mergedListTail.next;
                }
                l = l.next;
            } else {
                if (mergedListHead == null) {
                    mergedListHead = r;
                    mergedListTail = r;
                } else {
                    mergedListTail.next = r;
                    mergedListTail = mergedListTail.next;
                }
                r = r.next;
            }
        }

        while (l != null) {
            if (mergedListHead == null) {
                mergedListHead = l;
                mergedListTail = l;
            } else {
                mergedListTail.next = l;
                mergedListTail = mergedListTail.next;
            }
            l = l.next;
        }
        while (r != null) {
            if (mergedListHead == null) {
                mergedListHead = r;
                mergedListTail = r;
            } else {
                mergedListTail.next = r;
                mergedListTail = mergedListTail.next;
            }
            r = r.next;
        }
        // print(mergedListHead);
        return mergedListHead;
    }

}
