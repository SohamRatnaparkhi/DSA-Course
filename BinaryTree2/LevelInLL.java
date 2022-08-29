package BinaryTree2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelInLL extends LevelwiseTree{

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        ArrayList<LinkedListNode<Integer>> ans = addLevelWise(root);
        for (LinkedListNode<Integer> l : ans) {
            while (l != null) {
                System.out.print(l.data + " ");
                l = l.next;
            }
            System.out.println();
        }
    }
    
    public static ArrayList<LinkedListNode<Integer>> addLevelWise(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> pendingElements = new LinkedList<>();
        ArrayList<LinkedListNode<Integer>> ans = new ArrayList<>();
        if (root != null) {
            pendingElements.add(root);
        }
        int level = 1;
        while (!pendingElements.isEmpty()) {
            int queueLength = pendingElements.size();
            System.out.print("Level " + level + " : ");
            LinkedListNode<Integer> temp = null;
            LinkedListNode<Integer> tempt = null;
            for (int i = 0; i < queueLength; i++) {
                BinaryTreeNode<Integer> front = pendingElements.poll();
                System.out.print(front.data + " ");
                LinkedListNode<Integer> newNode = new LinkedListNode<>(front.data); 
                if (temp == null) {
                    temp = newNode;
                    tempt = newNode;
                } else {
                    tempt.next = newNode;
                    tempt = tempt.next;
                }
                if (front.left != null) {
                    pendingElements.add(front.left);
                }
                if (front.right != null) {
                    pendingElements.add(front.right);
                }
            }
            System.out.println();
            ans.add(temp);
            temp = null;
            level++;
        }
        return ans;
    }
}

class LinkedListNode<T> { 

	T data; 
	LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}