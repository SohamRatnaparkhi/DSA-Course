package LinkedList;

import java.util.Scanner;


public class LLUse2 extends LinkedListNode<Integer> {
    public LLUse2(Integer data) {
        super(data);
    }

    public static void main(String[] args) {

        LinkedListNode<Integer> head = llInput();
        print(head);

        // LinkedListNode<Integer> insertedNodeHead = insertNode(head, 3, 10);
        // print(insertedNodeHead);

        // LinkedListNode<Integer> deletedNodeHead = deleteNode(head, 3);
        // print(deletedNodeHead);

        // LinkedListNode<Integer> appendedNLast = appendLastNToFirst(head, 3);
        // print(appendedNLast);

        // LinkedListNode<Integer> removedDuplicates = removeDuplicates(head);
        // print(removedDuplicates);
        
        // boolean isPall = isPalindrome(head);

        LinkedListNode<Integer> reverseNode = reverseNode(head);
        print(reverseNode);


    }

    private static LinkedListNode<Integer> reverseNode(LinkedListNode<Integer> head) {
        // LinkedListNode<Integer> reverseHead = null;
        LinkedListNode<Integer> prevNode = null;
        LinkedListNode<Integer> nextNode = null;
        LinkedListNode<Integer> currNode = head;
        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head = prevNode;
        return head;
    }

    public static boolean isPalindrome(LinkedListNode<Integer> head) {
		//Your code goes here
        LinkedListNode<Integer> reversedList = null;
        LinkedListNode<Integer> tail = head;
        
        while(tail != null){
        	LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(tail.data);
        	newNode.next = reversedList;
            reversedList = newNode;     
            tail = tail.next;
        }
        while(head != null || reversedList != null){
            if(head.data == reversedList.data){
                head = head.next;
                reversedList = reversedList.next;
            } else {
                return false;
            }
            
        }
        return true;
	}

    private static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
        // LinkedListNode<Integer> ans = null;
        // LinkedListNode<Integer> ansTail = ans;
        // while (head != null) {
        //     while (head.next != null && head.data == head.next.data) {
        //         head = head.next;
        //     }

        //     if (head != null) {
        //         LinkedListNode<Integer> temp = new LinkedListNode<>(head.data);
        //         if (ans == null) {
        //             ans = temp;
        //             ansTail = temp;
        //         } else {
        //             ansTail.next = temp;
        //             ansTail = ansTail.next;
        //         }
        //     }
            
        //     head = head.next;
        // }
        // return ans;
        LinkedListNode<Integer> ptr1, ptr2 = null;
        ptr1 = head;
        while(ptr1 != null || ptr2 != null){
            ptr2 = ptr1.next;
            while(ptr2 != null && ptr1.data == ptr2.data){
                ptr2 = ptr2.next;
            }
            ptr1.next = ptr2;
            ptr1 = ptr2;
        }
        return head;
    }

    private static LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int lastN) {
        /*
         * 1 2 3 4 5
         * if pos = 3
         * ans = 3 4 5 1 2
         */

        LinkedListNode<Integer> tail = head;
        LinkedListNode<Integer> temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        int pos = length - lastN;
        for (int i = 0; i < pos - 1; i++) {
            tail = tail.next;
        }

        LinkedListNode<Integer> newHead = tail.next;
        LinkedListNode<Integer> tail2 = newHead;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }

        tail2.next = head;
        tail.next = null;

        return newHead;
    }

    private static LinkedListNode<Integer> deleteNode(LinkedListNode<Integer> head, int pos) {
        /*
         * 1 -> 2-> 3 -> 4 -> 5
         * if pos = 2(i.e. 3rd index) node
         * 1 -> 2 -> 4 -> 5
         * 
         * ? Go to previous node
         * ? make required connections
         */
        LinkedListNode<Integer> prev = head;
        for (int i = 0; i < pos - 1; i++) {
            prev = prev.next;
        }
        LinkedListNode<Integer> remove = prev.next;
        prev.next = remove.next;
        remove.next = null;

        return head;
    }

    private static LinkedListNode<Integer> insertNode(LinkedListNode<Integer> head, int pos, int data) {
        /*
         * 1 -> 2-> 3 -> 4 -> 5
         * add 10 at 3rd pos(index)
         * 1-> 2-> 3-> 10 -> 4-> 5
         * 
         * ? make connection btwn newNode and next `position` node
         * ? then make connection btwn posn node and newNode
         */

        LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
        LinkedListNode<Integer> posn = head;

        if (pos == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        for (int i = 0; i < pos - 1; i++) {
            posn = posn.next;
        }
        newNode.next = posn.next;
        posn.next = newNode;

        return head;
    }

    public static void print(LinkedListNode<Integer> head) {
        if (head == null) {
            System.out.println("END");
            return;
        }
        System.out.print(head.data);
        System.out.print(" --> ");

        print(head.next);
    }

    static Scanner sc = new Scanner(System.in);

    public static LinkedListNode<Integer> llInput() {
        System.out.println("Enter elements in Linkedlist:");
        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> tail = new LinkedListNode<Integer>();
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
