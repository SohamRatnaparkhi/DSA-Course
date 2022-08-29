package LinkedList;

import java.util.ArrayList;

public class addLLtoAL {
    public static void main(String[] args) {
        ArrayList<LinkedListNode<Integer>> al = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            LinkedListNode<Integer> temp = new LinkedListNode<>(i);
            al.add(temp);
            temp = null;
        }
        for (LinkedListNode<Integer> l : al) {
            System.out.println(l.data);
        }
    }
}
