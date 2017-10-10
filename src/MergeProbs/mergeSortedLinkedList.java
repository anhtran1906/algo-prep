package MergeProbs;

import java.util.LinkedList;

/**
 * Created by anhtran on 10/7/17.
 *
 * singly linkedlist
 * ll1: 1->2->3
 * ll2: 2->3->4
 *
 * result: 1->2->3->4
 *
 */
public class mergeSortedLinkedList {
    private class Node{
        int val;
        Node next;
        public Node(int x) {
            val = x;
            next = null;
        }
    }


    public static LinkedList<Node> mergeLists(Node head1, Node head2){
        if(head1 == null) {

        }
        LinkedList<Node> result = new LinkedList<>();
        Node dummy = result.getFirst();
        Node prev = dummy;
        Node cur = prev.next;

        return null;
    }
}
