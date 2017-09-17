import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by anhtran on 7/15/17.
 */
public class SearchTrie {
    private static class Node {
        private int NUMBER_OF_CHARACTERS = 26;
        private Node[] children = new Node[NUMBER_OF_CHARACTERS];
        private int countLeaf;
        private int weight;

        public Node() {
            countLeaf = 0;
            weight = 0;
            for (int i = 0; i < NUMBER_OF_CHARACTERS; i++) {
                children[i] = null;
            }
        }
    }
    private static class Trie {
        private Node root;

        public Trie() {
            root = new Node();
        }
        private int getNodeLevel(char c) {
            return c - 'a';
        }

        private void add(String s, int priority) {
            Node temp = root;
            for (int i = 0; i < s.length(); i++) {
                int level = getNodeLevel(s.charAt(i));
                if (temp.children[level] == null) {
                    temp.children[level] = new Node();
                }
                temp = temp.children[level];
            }
            temp.countLeaf++;
            temp.weight=priority;
        }

        private boolean isLeafNode(Node node){
            return node.countLeaf != 0;
        }

        private boolean hasChildren(Node node){
            for(int i = 0; i < node.NUMBER_OF_CHARACTERS; i++){
                if(node.children[i] != null){
                    return false;
                }
            }
            return true;
        }

        private PriorityQueue<Integer> findListWithPrefix(String s) {
            Node temp = root;
            PriorityQueue<Integer> priorityList = new  PriorityQueue<Integer>(Collections.reverseOrder());
            for (int i = 0; i < s.length(); i++) {
                int level = getNodeLevel(s.charAt(i));
                Node cur = temp.children[i];
                if ( cur == null) {
                    return priorityList;
                }
                int j = i;
                if(level == s.length()-1 && !isLeafNode(cur) && hasChildren(cur)){
                    while(hasChildren(cur)){
                        cur = temp.children[j++];
                        if (cur.countLeaf > 0){
                            priorityList.add(cur.weight);
                        }
                    }
                }
                temp = temp.children[level];
            }
            return priorityList;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        Trie trie = new Trie();

        for(int i = 0; i < n; i++) {
            trie.add(sc.next(),sc.nextInt());
        }
        for(int i = 0; i < q; i++){
            PriorityQueue<Integer> list = trie.findListWithPrefix(sc.next());
            if(list.isEmpty()) {
                System.out.println(-1);
                return;
            }
            else {
                System.out.println(list.poll());
                return;
            }
        }

    }
}
