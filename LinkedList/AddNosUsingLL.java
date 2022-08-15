public class AddNosUsingLL extends MidPoint{
    public static void main(String[] args) {
        LinkedListNode<Integer> l1 = makeLL();
        LinkedListNode<Integer> l2 = makeLL();
        LinkedListNode<Integer> sum = addTwoNumbers(l1, l2);
        print(sum); 
    }
    public static LinkedListNode<Integer> addTwoNumbers(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2) {
        LinkedListNode<Integer> ans = null;
        LinkedListNode<Integer> ansTail = null;
        int carry = 0;
        while(l1 != null && l2 != null) {
            int sum = carry + l1.data + l2.data;
            carry = sum / 10;
            sum %= 10;
            LinkedListNode<Integer> s = new LinkedListNode<Integer>(sum);
            if(ans == null) {
                ans = s;
                ansTail = s;
            } else {
                ansTail.next = s;
                ansTail = ansTail.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            int sum = carry + l1.data;
            carry = sum / 10;
            sum %= 10;
            LinkedListNode<Integer> s = new LinkedListNode<Integer>(sum);
            l1 = l1.next;
            ansTail.next = s;
            ansTail = ansTail.next;
        }
        
        while (l2 != null) {
            int sum = carry + l2.data;
            carry = sum / 10;
            sum %= 10;
            LinkedListNode<Integer> s = new LinkedListNode<Integer>(sum);
            ansTail.next = s;
            l2 = l2.next;
            ansTail = ansTail.next;
        }
        
        if (carry == 1) {
            LinkedListNode<Integer> s = new LinkedListNode<Integer>(1);
            ansTail.next = s;
            ansTail = ansTail.next;
        }
        
        return ans;
    }
}
