// package LinkedList;

public class StaticLLUse {
    public static void main(String[] args) {
        
        Node head = new Node();
        head = createLL();

        printLL(head);

    }
    public static Node createLL(){
        // 10 -> 20 -> 30 -> 40 -> 50
        Node head = new Node();
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        return head;
    }

    public static void printLL(Node head){

        if(head.next == null){
            System.out.println("null");
            return;
        }

        Node nextNode = head.next;
        System.out.print(nextNode.data);
        // System.out.print(nextNode);
        System.out.print(" --> ");

        printLL(nextNode);
    }

}
