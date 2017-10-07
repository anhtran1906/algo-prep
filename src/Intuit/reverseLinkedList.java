package Intuit;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by anhtran on 9/23/17.
 */
public class reverseLinkedList {
    public static ListNode head;
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
     }
    public static ListNode reverseList(ListNode headNode) {
        if(headNode == null || headNode.next == null){
            return headNode;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = prev.next;
        ListNode suc = cur.next;

        while(cur != null && suc!= null){
            cur.next = suc.next;
            suc.next = prev.next;
            prev.next = suc;
            suc = cur.next;
        }
        return dummy.next;
    }

    static void printList(LinkedList list) {
        Iterator<ListNode> i = list.iterator();
        while(i.hasNext()){
            System.out.println(i.next().val);
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList<ListNode> list = new LinkedList<>();
        while(sc.hasNext()){
            if(list.size() == 0) {
                ListNode cur = new ListNode(sc.nextInt());
                reverseLinkedList.head = cur;
                list.add(new ListNode(sc.nextInt()));
            }
            list.add(new ListNode(sc.nextInt()));
        }
        printList(list);
        System.out.println(reverseList(reverseLinkedList.head).val);
        printList(list);
    }
}
