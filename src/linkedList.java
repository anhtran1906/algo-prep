///**
// * Created by anhtran on 9/22/17.
// */
//public class linkedList {
//    // package whatever; // don't place package name!
//
//
///*
//Given a 2 singly linked list
//Write a program to find the node at which the intersection of two singly linked lists begins.
//
//
//1->2->3
//4->3->5
//
//1->2->3   => 3
//4->3
//
//backward
//
//forward
//
//Condition: find the node that starting from this node, every next node from 2 lists are equal
//
//A: 5          a1 → a2
//                       ↘
//                            c1 → c2 → c3 ->d1
//                                         ->d2
//                       ↗
//
//
//B:7  b0->b1 → b2 → b3
//
//
//size = Math.max(a,b)
//
//for(i=0->size){
// a[i] == b[i]
// j =i+1;
// while(a[j+1] == b[j+1]){
//    j++;
//    if(j -> min(a,b)){
//
//        break;
//    }
//    }
// }
//
// }
//}
//*/
//
//    class ListNode {
//        public:
//        int val;
//        ListNode* next;
//    }
//
//import java.io.*;
//
//    class myCode
//    {
//
//        public static ListNode findIntersectNode(ListNode roota, ListNode rootb){
//            int sizeA = 0;
//            int sizeB = 0;
//
//            //find size A
//
//            ListNode curSizeA = roota;
//
//            while(curSizeA.next != null){
//                sizeA++;
//                curSizeA = curSizeA.next;
//            }
//
//            //find size B
//            ListNode curSizeB = rootb;
//
//            while(curSizeB.next != null){
//                sizeB++;
//                curSizeB = curSizeB.next;
//
//            }
//
//            int diff = Math.abs(sizeA - sizeB);
//            // 1->2->3
//            // 4->3
//
//            if(sizeA > sizeB){
//                int i = 0;
//                ListNode curA = rootA;
//                while(i < diff) {
//                    curA = curA.next;
//                    i++;
//                }
//                ListNode curB = rootB;
//
//                while(curA.val != curB.val) {
//                    curA = curA.next;
//                    curB = curB.next;
//                }
//
//                if(curA.val == curB.val){ //curA ->null curA is tail;
//                    return curA;
//                }
//                else {
//                    return null;
//                }
//
//                //return curA or curB
//
//
//            }
//
//            //handle equal sizes => no need b/c it handles
//
//
//
//            if(sizeB > sizeA){
//                int i = 0;
//                ListNode curA = rootA;
//                while(i < diff) {
//                    curA = curA.next;
//                }
//                ListNode curB = rootB;
//
//                while(curA.val != curB) {
//                    curA = curA.next;
//                    curB = curB.next;
//                }
//
//                if(curA.val == curB. val){
//                    return curA;
//                }
//                else {
//                    return null;
//                }
//
//
//            }
//
//
//
//
//        }
//
//
//
//
//        public static void main (String[] args) throws java.lang.Exception
//        {
//            System.out.println("Hello Java");
//        }
//    }
//
//
//}
