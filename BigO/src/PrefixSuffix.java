import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by anhtran on 7/20/17.
 */
public class PrefixSuffix {
    private static final int NUMBER_OF_CHARACTER = 26;
    private static class Node{
        private Node[] children;
        private boolean markWord;
        public Node(){
            children = new Node[NUMBER_OF_CHARACTER];
            markWord = false;
            for(int i = 0; i < NUMBER_OF_CHARACTER; i++){
                children[i] = null;
            }
        }
    }

    private static class Trie {
        private static Node root;
        public Trie(){
            root = new Node();
        }
        private int getNodeLevel(char c){
            return c - 'a';
        }
        public void add(String s){
            Node temp = root;
            for(int i = 0; i < s.length(); i++){
                int level = getNodeLevel(s.charAt(i));
                if(temp.children[level] == null){
                    temp.children[level] = new Node();
                }
                temp = temp.children[level];
            }
            temp.markWord = true;
        }


    }

    public static String reverseWord(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length -1;
        while(i < s.length() && j >= 0) {
            arr[j] = s.charAt(i);
            i++;
            j--;
        }
        return String.copyValueOf(arr);
    }

    private static long[] startWith = new long[NUMBER_OF_CHARACTER];
    private static long sufficeStateCount;

    public static void suffixTraversal(Node node, int level){
        sufficeStateCount++;
        for(int i = 0; i < NUMBER_OF_CHARACTER; i++){
            if(node.children[i] == null){
                continue;
            }
            if(level > 0) {
                startWith[i]++;
                suffixTraversal(node.children[i], level+1);
            }
        }
    }

    public static long prefixTraversal(Node node, int level){
        long result = 0;
        if(level > 0){
            result += sufficeStateCount;
        }
        for(int i = 0; i < NUMBER_OF_CHARACTER; i++){
            if(node.children[i] == null){
                continue;
            }
            if(level > 0){
                result -= startWith[i];
            }
            result += prefixTraversal(node.children[i], level+1);
        }
        return result;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int prefixNum = sc.nextInt();
        int suffixNum = sc.nextInt();
        Trie prefixTrie = new Trie();
        Trie suffixTrie = new Trie();

        for(int i = 0; i < NUMBER_OF_CHARACTER; i++){
            startWith[i] = 0;
        }
        sufficeStateCount = 0;

        for (int i = 0; i < prefixNum; i++) {
            prefixTrie.add(sc.next());
        }
        for (int j = 0; j < suffixNum; j++) {
            String reversed = reverseWord(sc.next());
            suffixTrie.add(reversed);
        }
        suffixTraversal(suffixTrie.root, 0);
        sufficeStateCount--;
        System.out.println(prefixTraversal(prefixTrie.root, 0));

        if(sc.next().equals("0 0")){
            return;
        }
    }
}
