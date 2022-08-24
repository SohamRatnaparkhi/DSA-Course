package LinkedList;


public class DelAlternateNodes extends MidPoint{
    public static void main(String[] args) {
        LinkedListNode<Integer> head = makeLL();
        print(head);

        LinkedListNode<Integer> newHead = deleteAlt(head);
        print(newHead);
    }

    private static LinkedListNode<Integer> deleteAlt(LinkedListNode<Integer> head) {

        if(head == null || head.next == null) {
            return head;
        }
        
        LinkedListNode<Integer> currNode = null;
        LinkedListNode<Integer> prevNode = head;
        LinkedListNode<Integer> nextNode = null;

        while (prevNode != null && prevNode.next != null) {
            currNode = prevNode.next;
            nextNode = currNode.next;
            prevNode.next = nextNode;

            prevNode = nextNode;
        }
        
        return head;
    }
}
