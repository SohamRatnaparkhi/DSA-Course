package LinkedList;

public class ShiftLLbyN extends MidPoint {
    public static void main(String[] args) {
        LinkedListNode<Integer> head = makeLL();
        print(head);    
        System.out  .println("Enter n");
        LinkedListNode<Integer> newHead = shiftByN(head, sc.nextInt()); 
        print(newHead);
    }   

    private static LinkedListNode<Integer> shiftByN(LinkedListNode<Integer> head, int n) {
        // 1-2-3-4-5-6 and n = 2    
        // 1-2-3-4-||||5-6   
        // 5-6-   1-2-3-4 
        // 1-2-3-4-5-6 and n = 8
        // 5-6-1-2-3-4 
        int l = lenght(head);
        n = n % l;  
        int firstHalfLength = l - n;
        LinkedListNode<Integer> curr = head;    
        LinkedListNode<Integer> prev = null;    
        int i = 0;
        while (i++ < firstHalfLength) {
            prev = curr; 
            curr = curr.next;
            // curr = 5-6 
            // prev = 4-5-6
        }
        LinkedListNode<Integer> currTail = curr;
        while (currTail.next != null) {
            currTail = currTail.next;
            // currTail = 6
        }    
        // print(currTail);
        // currTail->head ; curr=head
        currTail.next = head;
        // print(currTail);
        head = curr;
        prev.next = null;

        return head;
    }

    private static int lenght(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> curr = head;    
        int length = 0;
        while (curr != null) {
            length ++;
            curr = curr.next;
        }
        return length;
    }
}
