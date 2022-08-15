// package LinkedList;

public class SkipDelete extends MidPoint{
    public static void main(String[] args) {
        LinkedListNode<Integer> head = makeLL();
        int i = 3, j = 5; 
        LinkedListNode<Integer> newHead = swapNodes(head, i, j);
        print(newHead);
    }

    static int c = 0;
	public static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {
		//Your code goes here
        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> prev1 = null;
        LinkedListNode<Integer> prev2 = null;
        
        while (current != null && c < i){
            prev1 = current;
            current = current.next;
            c++;
        }
        LinkedListNode<Integer> node1 = current;
        
        while (current != null && c < j){
            prev2 = current;
            current = current.next;
            c++;
        }
        LinkedListNode<Integer> node2 = current;
        
        if (node2.next == null){
            node2.next = node1.next;
            prev1.next = node2;
            prev2.next = node1;
            node1.next = null;
        } else {
            LinkedListNode<Integer> temp = node2;
            node2.next = node1.next;
            prev1.next = node2;
            prev2.next = node1;
            node1.next = temp.next;
        }
        
    	return head;
	}
}
