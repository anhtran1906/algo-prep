import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by anhtran on 7/15/17.
 */

public class Trie {
    public static class TrieStruct {
        private class Node {
            private int NUMBER_OF_DIGITS = 10;
            private Node[] children = new Node[NUMBER_OF_DIGITS];
            private int countLeaf;

            public Node() {
                countLeaf = 0;
                for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
                    children[i] = null;
                }
            }
        }

        private Node root;

        public TrieStruct() {
            root = new Node();
        }

        private int getNodeLevel(int n) {
            return n - 0;
        }

        private boolean add(Integer number) {
            Node temp = root;
            char[] curNum = number.toString().toCharArray();
            for (int i = 0; i < curNum.length; i++) {
                int curDigit = Integer.parseInt(Character.toString(curNum[i]));
                int level = getNodeLevel(curDigit);
                if (temp.children[level] == null) {
                    temp.children[level] = new Node();
                }
                else if(temp.children[level].countLeaf > 0){
                    return false;
                }
                temp = temp.children[level];
            }
            temp.countLeaf++;
            return true;
        }

//        private boolean findNum(int n) {
//            Node temp = root;
//            for (int i = 0; i < n; i++) {
//                int level = getNodeLevel(n);
//                if (temp.children[i] == null) {
//                    return false;
//                }
//                temp = temp.children[level];
//            }
//            return temp.countLeaf > 0;
//        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        int i = 1;
        while(i <= tests){
            int length = sc.nextInt();
            TrieStruct trie = new TrieStruct();
            ArrayList<Integer> input = new ArrayList<Integer>();
            boolean isPrefixed = false;
            for(int j = 0; j < length; j++){
                int cur = sc.nextInt();
                input.add(cur);
                if(!trie.add(cur)){
                    isPrefixed = true;
                }
            }

//
//            for(int z = 0; z < length; z++){
//                char[] curNum = input.get(z).toString().toCharArray();
//
//               for(int f = 0; f < curNum.length; f++) {
//                   boolean found = trie.findNum(Integer.parseInt(Character.toString(curNum[f])));
//                   if (found && f < curNum.length) {
//                       isPrefixed = true;
//                       return;
//                   }
//               }
//            }

            if(isPrefixed){
                System.out.println("Case " + i + ": " + "NO");
            }
            else {
                System.out.println("Case " + i + ": " + "YES");
            }
            i++;
        }
    }
}

