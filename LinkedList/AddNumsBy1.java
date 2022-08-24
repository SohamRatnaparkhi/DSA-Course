package LinkedList;

public class AddNumsBy1 extends MidPoint {
    public static void main(String[] args) {
        LinkedListNode<Integer> number = makeLL();
        print(number);
        // LinkedListNode<Integer> ans = numberPlus1(number);
        // print(ans);
        LinkedListNode<Integer> ans2 = nextLargeNumber(number);
        print(ans2);
    }

    static boolean add = true;
    static int length = 0;
    static int zeros = 0;

    private static LinkedListNode<Integer> numberPlus1(LinkedListNode<Integer> head) {
        if (head == null) {
            return head;
        }
        length += 1;
        LinkedListNode<Integer> nextNodes = numberPlus1(head.next);
        if (nextNodes == null) {
            if (head.data != 9)
                head.data += 1;
            else {
                head.data = 0;
                LinkedListNode<Integer> ans2 = new LinkedListNode<>(1);
                ans2.next = head;
                return ans2;
            }
            add = false;
        } else if (nextNodes != null) {
            // System.out.println("in 2");
            if (add) {
                if (nextNodes.data == 9) {
                    zeros += 1;
                    nextNodes.data = 0;
                    add = true;
                    if (head.data == 9) {
                        zeros += 1;
                        head.data = 0;
                        add = true;
                        // System.out.println(add);
                    } else {
                        head.data += 1;
                        add = false;
                        // System.out.println(add);
                    }
                } else {
                    if (head.data == 9) {
                        head.data = 0;
                        zeros += 1;
                        add = true;
                    } else {
                        head.data += 1;
                        add = false;
                    }

                }
            }
        }
        // return head;
        LinkedListNode<Integer> ans2 = new LinkedListNode<>(1);
        ans2.next = head;
        // System.out.println(length + " " + zeros);
        return zeros != length - 1 ? head : ans2;
    }

    public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {
        
        if(head == null) {
            return head;
        }
        if(head.next == null) {
            head.data += 1;
            if(head.data > 9) {
                head.data %= 10;
                LinkedListNode<Integer> t = new LinkedListNode<Integer>(1);
                t.next = head;
                return t;
            } else {
                return head;
            }
        }
        
        LinkedListNode<Integer> rev = reverseLL(head);
        LinkedListNode<Integer> revC = rev;
        int carry = 1;
        while(revC != null) {
            revC.data += carry;
            if(revC.data > 9) {
                revC.data %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            revC = revC.next;
        }
        LinkedListNode<Integer> r = reverseLL(rev);
        if(carry == 1) {
            LinkedListNode<Integer> t = new LinkedListNode<Integer>(1);
                t.next = r;
        }
        return r;
	}

	public static LinkedListNode<Integer> reverseLL(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> prevN = null; 
        LinkedListNode<Integer> currN = head;
        LinkedListNode<Integer> nextN = null;
        
        while(currN != null) {
            nextN = currN.next;
            currN.next = prevN;
            prevN = currN;
            currN = nextN;
        }
        head = prevN;
        return head;
        
    } 
}
