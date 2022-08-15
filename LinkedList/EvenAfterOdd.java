// package LinkedList;

public class EvenAfterOdd extends MidPoint {
    public static void main(String[] args) {
        LinkedListNode<Integer> head = makeLL();
        LinkedListNode<Integer> shuffleLinkedListHead = shuffleLL(head);
        print(shuffleLinkedListHead);
    }

    private static LinkedListNode<Integer> shuffleLL(LinkedListNode<Integer> head) {

        LinkedListNode<Integer> evenList = null;
        LinkedListNode<Integer> oddList = null;
        LinkedListNode<Integer> currNode = head;
        LinkedListNode<Integer> evenNode = null;
        LinkedListNode<Integer> oddNode = null;

        while (currNode != null) {
            LinkedListNode<Integer> nodeToAdd = new LinkedListNode<Integer>(currNode.data);
            int data = nodeToAdd.data;
            if (data % 2 == 0) {
                if (evenList == null) {
                    evenList = nodeToAdd;
                    evenNode = nodeToAdd;
                } else {
                    evenNode.next = nodeToAdd;
                    evenNode = evenNode.next;
                }
            } else {
                if (oddList == null) {
                    oddList = nodeToAdd;
                    oddNode = nodeToAdd;
                } else {
                    oddNode.next = nodeToAdd;
                    oddNode = oddNode.next;
                }
            }
            currNode = currNode.next;
        }
        if(oddList != null){
            oddNode.next = evenList;
        } else {
            return evenList;
        }
        return oddList;
    }
}
