// package LinkedList;

public class AppendLastN extends MidPoint {
    public static void main(String[] args) {
        LinkedListNode<Integer> head = makeLL();
        print(head);
        int n = 2;
        LinkedListNode<Integer> newHead = appendLastNToFirst(head, n);
        print(newHead);
    }
    public static LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int n) {
		//Your code goes here
        LinkedListNode<Integer> tail = head;
        int length = 0;
        
        while(tail.next != null){
            length ++;
            tail = tail.next;
        }
        length++;
        if(length == 0 || n == 0){
            return head;
        }
        // System.out.println(length);
        int pos = length - n;
        LinkedListNode<Integer> currNode = head;
        LinkedListNode<Integer> prevNode = null;
        
        for(int i = 0; i < pos; i ++){
            prevNode = currNode;
            currNode = currNode.next;
        }
        
        // LinkedListNode<Integer> tail2 = currNode;
        // while(tail2.next != null){
        //     tail2 = tail2.next;
        // }
        tail.next = head;
        prevNode.next = null;
        head = currNode;
        
        
        return head;
		
	}

}
